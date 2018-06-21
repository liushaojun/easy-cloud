FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ADD target/ec-config*.jar /app.jar
EXPOSE 8888
WORKDIR /app
ENV EUREKA_URI http://eureka1:8761/eureka,http://eureka2:8761/eureka,http://eureka2:8761/eureka
ENV ADMIN_URI http://admin:9000
ENV RABBITMQ_HOST rabbitmq

ENTRYPOINT ["java","-jar","/app.jar"]
