FROM adoptopenjdk/openjdk11
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=build/libs/*.jar
ENV SPRING_PROFILE=prod
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod ", "/app.jar"]