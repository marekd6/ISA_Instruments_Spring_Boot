#FROM nginx:1.23.3
### STAGE 1: Build ###
FROM node:19.5.0 AS build

LABEL org.opencontainers.image.title="orchestra-ng"
LABEL org.opencontainers.image.authors="MD191684"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Orchestra application - Angular"

ENV VERSION="1.0-SNAPSHOT"


WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.23.3
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/orchestra-ng /usr/share/nginx/html
#
#WORKDIR /usr/local/app
#
#COPY . /usr/local/app
#
#RUN npm install
#RUN npm run build
#
#FROM nginx:1.23.3
#
#COPY --from=ang /usr/local/app/dist/orchestra-ng /usr/share/nginx/html
#
#EXPOSE 80


#ENV API_URL http://localhost:8080/api
#
#EXPOSE 80
#
#ADD dist/orchestra-ng /usr/share/nginx/html/
#ADD docker/etc/nginx/templates/ /etc/nginx/templates/
