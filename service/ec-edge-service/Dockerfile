FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com

WORKDIR /app
ADD target/ec-edge-service*.jar /app.jar
VOLUME /tmp/logs:/app/logs
EXPOSE 8070
ENV EUREKA_URL http://discovery-server:8761/eureka
ENV RABBITMQ_HOST rabbitmq
ENV ADMIN_URL: http://admin-server:9000
ENTRYPOINT ["java","-jar","/app.jar"]
