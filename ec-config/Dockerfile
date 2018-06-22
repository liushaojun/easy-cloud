FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
EXPOSE 8888
WORKDIR /app
ENV EUREKA_URL http://discovery-server:8761/eureka
ENV ADMIN_URL http://admin-server:9000
ENV RABBITMQ_HOST rabbitmq

ENTRYPOINT ["java","-jar","/app.jar"]
