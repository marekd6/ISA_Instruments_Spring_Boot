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

EXPOSE 80

#ENTRYPOINT ["nginx", "-g", "daemon off;"]

#ENV ORCHESTRA_INSTRUMENT_URL=orchestra-instrument
#ENV ORCHESTRA_SECTION_URL=orchestra-section

#COPY nginx.conf /etc/nginx/nginx.conf

#ENTRYPOINT ["nginx", "-g", "daemon off;"]

#ENV NGINX_ENVSUBST_OUTPUT_DIR=/etc/nginx
COPY templates/nginx.conf.template /etc/nginx/templates/

#ENV INSTRUMENT_PORT=8081
#ENV SECTION_PORT=8082
#ENTRYPOINT ["nginx", "-g", "daemon off;"]
