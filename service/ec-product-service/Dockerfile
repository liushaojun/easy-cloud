FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
EXPOSE 8090
ENV EUREKA_URL http://discovery-server:8761/eureka
ENV ZIPKIN_HOST zipkin
ENTRYPOINT ["java","-jar","/app.jar"]
