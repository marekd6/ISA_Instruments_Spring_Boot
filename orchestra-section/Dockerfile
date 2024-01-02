FROM eclipse-temurin:20.0.2_9-jre

LABEL authors="MD191684"
LABEL org.opencontainers.image.title="orchestra-section"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Orchestra application - module for Section"

ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8082

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:orchestra-section
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV ORCHESTRA_INSTRUMENT_URL=http://localhost:8081

ENV SPRING_MAIN_WEB_APPLICATION_TYPE=servlet

EXPOSE 8082

COPY target/orchestra-section-${VERSION}.jar /opt/orchestra-section/orchestra-section.jar

CMD ["java", "-jar", "/opt/orchestra-section/orchestra-section.jar"]
