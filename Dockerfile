FROM openjdk:17-jdk-slim
WORKDIR /app
ADD /target/legal-tracker-portal.jar legal-tracker.jar
EXPOSE 8007
CMD ["java", "-jar", "legal-tracker.jar"]