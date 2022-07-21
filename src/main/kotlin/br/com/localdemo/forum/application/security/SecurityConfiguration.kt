package br.com.localdemo.forum.application.security

import org.springframework.beans.factory.annotation.Qualifier
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
import org.springframework.web.servlet.HandlerExceptionResolver

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val configuration: AuthenticationConfiguration,
    private val jwtUtil: JwtUtil,
    private val authEntryPoint: DelegatedAuthenticationEntryPoint,
    @Qualifier("handlerExceptionResolver")
    private var resolver: HandlerExceptionResolver
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic().disable()
            .csrf().disable()
            .authorizeHttpRequests()
            .antMatchers("/topics").hasAuthority("READ_WRITE")
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/actuator/health").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(authEntryPoint)

        http.addFilterBefore(
            JWTLoginFilter(authManager = configuration.authenticationManager, jwtUtil = jwtUtil),
            UsernamePasswordAuthenticationFilter().javaClass
        )

        http.addFilterBefore(JWTAuthenticationFilter(jwtUtil, resolver), UsernamePasswordAuthenticationFilter().javaClass)

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}