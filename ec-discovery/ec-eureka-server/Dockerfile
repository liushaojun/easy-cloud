FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
ENV EUREKA_SERVER_URL http://eureka:123456@discovery:8761/eureka
ENTRYPOINT ["java","-jar","/app.jar"]
