FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-eureka"

ENV VERSION="1.0-SNAPSHOT"

ENTRYPOINT ["java", "-jar", "/opt/orchestra-eureka/orchestra-eureka.jar"]

ENV SERVER_PORT=8080
EXPOSE $SERVER_PORT

ENV EUREKA_INSTANCE_HOSTNAME=localhost

ENV EUREKA_CLIENT_FETCH_REGISTRY=false
ENV EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8080/eureka

ENV EUREKA_SERVER_ENABLE_SELF_PRESERVATION=false
ENV EUREKA_SERVER_EVICTION_INTERVAL_TIMER_IN_MS=2000

COPY target/orchestra-instrument-${VERSION}.jar /opt/orchestra-eureka/orchestra-eureka.jar