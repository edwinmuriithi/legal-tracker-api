FROM openjdk:17-jdk-slim
WORKDIR /app
ADD /target/legal-tracker-portal.jar legal-tracker.jar
EXPOSE $PORT
CMD ["java", "-jar", "legal-tracker.jar"]