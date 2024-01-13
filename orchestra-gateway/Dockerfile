FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-gateway"

ENV VERSION="1.0-SNAPSHOT"

ENTRYPOINT ["java", "-jar", "/opt/orchestra-gateway/orchestra-gateway.jar"]

ENV SERVER_PORT=8083
EXPOSE $SERVER_PORT

ENV ORCHESTRA_GATEWAY_HOST=localhost:8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

COPY target/orchestra-gateway-${VERSION}.jar /opt/orchestra-gateway/orchestra-gateway.jar