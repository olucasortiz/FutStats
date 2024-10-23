FROM openjdk:21-jdk
WORKDIR /app
COPY target/FutStats-0.0.1-SNAPSHOT.jar /app/futstats.jar
ENTRYPOINT ["java", "-jar", "futstats.jar"]
EXPOSE 8080
