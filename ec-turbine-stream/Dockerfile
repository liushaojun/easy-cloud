FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com

WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
VOLUME /tmp/logs:/app/logs
EXPOSE 9001
ENV EUREKA_SERVER_URL http://eureka:123456@discovery:8761/eureka
ENV ADMIN_SERVER_URL http://admin-server:9000
ENV RABBITMQ_HOST rabbitmq
ENTRYPOINT ["java","-jar","/app.jar"]
