FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /build/libs/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "forum.jar"]