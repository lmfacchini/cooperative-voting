FROM openjdk:11



COPY cooperative-voting-ms-ws/target/cooperative-voting-spring-boot.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]


