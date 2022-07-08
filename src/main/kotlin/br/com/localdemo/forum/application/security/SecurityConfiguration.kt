package br.com.localdemo.forum.application.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val configuration: AuthenticationConfiguration,
    private val jwtUtil: JwtUtil
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .antMatchers("/topics").hasAuthority("READ_WRITE")
            .antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated()

        http.addFilterBefore(
            JWTLoginFilter(authManager = configuration.authenticationManager, jwtUtil = jwtUtil),
            UsernamePasswordAuthenticationFilter().javaClass
        )
        http.addFilterBefore(JWTAuthenticationFilter(jwtUtil), OncePerRequestFilter::class.java)

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}