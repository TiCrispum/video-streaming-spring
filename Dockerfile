FROM maven:3.8.4-eclipse-temurin-17-alpine AS builder
MAINTAINER Khalil SLEIMI <khalil.swdp@gmail.com>

# Build the project's jar
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -DskipTests

# Run the project
FROM maven:3.8.4-eclipse-temurin-17-alpine
COPY --from=builder /workspace/target/video-streaming-spring-0.0.1.jar ./
ADD ./videos ./videos
CMD ["java", "-Xmx200m", "-jar", "video-streaming-spring-0.0.1.jar"]