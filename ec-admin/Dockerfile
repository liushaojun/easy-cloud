FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
WORKDIR /app
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]
