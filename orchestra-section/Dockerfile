FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-section"

ENV VERSION="1.0-SNAPSHOT"

ENTRYPOINT ["java", "-jar", "/opt/orchestra-section/orchestra-section.jar"]

COPY target/orchestra-section-${VERSION}.jar /opt/orchestra-section/orchestra-section.jar

ENV SERVER_PORT=8082

EXPOSE $SERVER_PORT

ENV ORCHESTRA_INSTRUMENT_URL_ADDRESS=http://orchestra-instrument:8081

ENV EUREKA_INSTANCE_INSTANCE_ID=1

#ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086
