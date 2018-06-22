FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
