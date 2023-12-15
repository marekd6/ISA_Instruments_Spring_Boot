FROM eclipse-temurin:20.0.2_9-jre
LABEL authors="MD191684"
LABEL org.opencontainers.image.title="orchestra-instrument"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Orchestra application - module for Instrument"

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8081

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:orchestra-instrument
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8081

COPY target/orchestra-instrument-${VERSION}.jar /opt/orchestra-instrument/orchestra-instrument.jar

CMD ["java", "-jar", "/opt/orchestra-instrument/orchestra-instrument.jar"]
