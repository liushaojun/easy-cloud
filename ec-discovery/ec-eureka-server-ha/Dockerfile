FROM java:openjdk-8
MAINTAINER brook liushaojunvip@sina.com
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app.jar"]
