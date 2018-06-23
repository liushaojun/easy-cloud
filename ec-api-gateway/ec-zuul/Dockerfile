FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
WORKDIR /app
ENV EUREKA_SERVER_URL http://eureka:123456@discovery:8761/eureka
ENV ZIPKIN_HOST zipkin
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
