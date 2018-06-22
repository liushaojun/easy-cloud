FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com

WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
VOLUME /tmp/logs:/app/logs
EXPOSE 9001
ENV EUREKA_URL http://discovery-server:8761/eureka
ENV ADMIN_URL http://admin:9000

ENTRYPOINT ["java","-jar","/app.jar"]
