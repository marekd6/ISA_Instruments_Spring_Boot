FROM node:19-bullseye-slim

LABEL org.opencontainers.image.title="orchestra-ng"
LABEL org.opencontainers.image.authors="MD191684"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Orchestra application - Angular"

ENV VERSION="1.0-SNAPSHOT"

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Install project dependencies
RUN npm install

# Copy the entire project to the container
COPY . .

# Build the Angular app for production
RUN ng build

ENV API_URL http://localhost:8080/api

# Expose port 80 to the outside world
EXPOSE 80
EXPOSE 4200

# Run the Angular app when the container launches
CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200"]
