FROM eclipse-temurin:20.0.2_9-jre

LABEL authors="MD191684"
LABEL org.opencontainers.image.title="orchestra-instrument"

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8081

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/opt/orchestra-instrument/orchestra-instrument.jar"]

COPY target/orchestra-instrument-${VERSION}.jar /opt/orchestra-instrument/orchestra-instrument.jar