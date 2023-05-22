FROM openjdk:17-alpine
COPY ./target/PedidosAPI-0.0.1-SNAPSHOT.jar /app/PedidosAPI-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "PedidosAPI-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080