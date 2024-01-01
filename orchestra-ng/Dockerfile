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

COPY nginx.conf /etc/nginx/nginx.conf

#COPY --from=build /usr/src/app/dist/orchestra-ng /usr/share/nginx/html
COPY dist/orchestra-ng/browser /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
#CMD ["ng", "serve", "--host", "0.0.0.0",  "--port", "8080"]
