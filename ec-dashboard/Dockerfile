FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ADD target/ec-dashboard*.jar /app.jar
EXPOSE 9001
WORKDIR /app
ENV EUREKA_URL http://discovery-server:8761/eureka
ENV ADMIN_URL http://admin-server:9000

ENTRYPOINT ["java","-jar","/app.jar"]
