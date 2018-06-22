FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com

WORKDIR /app
ADD target/ec-consumer*.jar /app.jar
VOLUME /tmp/logs:/app/logs
EXPOSE 8001
ENV EUREKA_URL http://discovery-server:8761/eureka

ENTRYPOINT ["java","-jar","/app.jar"]
