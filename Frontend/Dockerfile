# ---------- STAGE 1: Build the React app ----------
FROM node:20-alpine AS build
WORKDIR /app

# Copy package files first for caching
COPY package*.json ./

# Install exact dependencies
RUN npm ci --silent

# Copy all app source code
COPY . .

# Build optimized production bundle
RUN npm run build


# ---------- STAGE 2: Serve with nginx ----------
FROM nginx:stable-alpine

# Remove default nginx HTML
RUN rm -rf /usr/share/nginx/html/*

# Copy React build output
COPY --from=build /app/build /usr/share/nginx/html

# Copy custom Nginx config (must include /api proxy)
COPY default.conf /etc/nginx/conf.d/default.conf

EXPOSE 3000

# Run Nginx
CMD ["nginx", "-g", "daemon off;"]
