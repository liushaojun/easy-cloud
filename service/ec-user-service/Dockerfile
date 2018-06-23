FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
EXPOSE 9001
WORKDIR /app
ENV EUREKA_SERVER_URL http://eureka:123456@discovery:8761/eureka
ENV ADMIN_SERVER_URL http://admin-server:9000
ENV MONGODB_HOST mongodb
ENV ZIPKIN_HOST zipkin

ENTRYPOINT ["java","-jar","/app.jar"]
