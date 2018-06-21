FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com

WORKDIR /app
ADD target/ec-turbine-stream*.jar /app.jar
VOLUME /tmp/logs:/app/logs
EXPOSE 9001
ENV EUREKA_URI http://eureka1:8761/eureka,http://eureka2:8761/eureka,http://eureka2:8761/eureka
ENV ADMIN_URI http://admin:9000

ENTRYPOINT ["java","-jar","/app.jar"]
