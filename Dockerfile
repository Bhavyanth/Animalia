from openjdk:17
EXPOSE 8080
ADD target/animalia.jar animalia.jar
ENTRYPOINT ["java", "-jar", "/animalia.jar"]