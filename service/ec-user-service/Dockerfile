FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp/logs:/app/logs
ADD target/ec-dashboard*.jar /app.jar
EXPOSE 9001
WORKDIR /app
ENV EUREKA_URI http://discovery-server:8761/eureka
ENV ADMIN_URI http://admin-server:9000
ENV MONGODB_HOST mongodb
ENV ZIPKIN_HOST zipkin

ENTRYPOINT ["java","-jar","/app.jar"]
