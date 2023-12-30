FROM eclipse-temurin:20.0.2_9-jre

LABEL org.opencontainers.image.title="orchestra-gateway"
LABEL org.opencontainers.image.authors="MD191684"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Orchestra application - gateway module"


ENV VERSION="1.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:orchestra-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV ORCHESTRA_GATEWAY_HOST=localhost:8080
ENV ORCHESTRA_INSTRUMENT_URL=http://localhost:8081
ENV ORCHESTRA_SECTION_URL=http://localhost:8082

EXPOSE 8080

COPY target/orchestra-gateway-${VERSION}.jar /opt/orchestra-gateway/orchestra-gateway.jar

CMD ["java", "-jar", "/opt/orchestra-gateway/orchestra-gateway.jar"]
