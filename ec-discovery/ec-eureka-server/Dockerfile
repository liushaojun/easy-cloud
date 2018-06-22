FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
WORKDIR /app
ADD target/ec-eureka*.jar /app.jar
ENV EUREKA_URL http://discovery-server:8761/eureka
ENTRYPOINT ["java","-jar","/app.jar"]
