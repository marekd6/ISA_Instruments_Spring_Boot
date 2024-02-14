#FROM node:20-alpine3.19 as build
#
##LABEL org.opencontainers.image.title="orchestra-ng"
#
#WORKDIR /usr/src/app
#
#COPY package*.json ./
#
#RUN npm install
#
#COPY . .
#
#RUN npm run build








FROM nginx:1.23-alpine3.17

LABEL org.opencontainers.image.title="orchestra-ng"

#COPY --from=build /usr/src/app/dist/orchestra-ng /usr/share/nginx/html
COPY dist/orchestra-ng/browser /usr/share/nginx/html

COPY templates/nginx.conf.template /etc/nginx/templates/

ENV NGINX_ENVSUBST_OUTPUT_DIR=/etc/nginx

ENV SERVER_PORT=80

EXPOSE $SERVER_PORT

ENV API_URL http://localhost:8080/api
