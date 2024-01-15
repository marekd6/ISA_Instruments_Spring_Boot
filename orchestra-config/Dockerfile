FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-config"

ENV VERSION="1.0-SNAPSHOT"

ENTRYPOINT ["java", "-jar", "/opt/orchestra-config/orchestra-config.jar"]

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_PROFILES_ACTIVE=native

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:/var/orchestra-config/configuration

VOLUME /var/orchestra-config/configuration

COPY target/orchestra-config-${VERSION}.jar /opt/orchestra-config/orchestra-config.jar

ENV SERVER_PORT=8080

EXPOSE $SERVER_PORT
