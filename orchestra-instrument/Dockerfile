FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-instrument"

ENV VERSION="1.0-SNAPSHOT"

ENTRYPOINT ["java", "-jar", "/opt/orchestra-instrument/orchestra-instrument.jar"]

COPY target/orchestra-instrument-${VERSION}.jar /opt/orchestra-instrument/orchestra-instrument.jar

ENV SERVER_PORT=8081

EXPOSE $SERVER_PORT

ENV EUREKA_INSTANCE_INSTANCE_ID=1

#ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086

