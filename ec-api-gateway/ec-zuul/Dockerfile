FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ADD target/ec-zuul*.jar /app.jar
WORKDIR /app
ENV EUREKA_URI http://eureka1:8761/eureka,http://eureka2:8761/eureka,http://eureka2:8761/eureka
ENV ZIPKIN_HOST zipkin
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
