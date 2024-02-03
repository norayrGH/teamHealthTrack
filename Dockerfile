FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} teamHelathTrack.jar
EXPOSE 8080
ENTRYPOINT [ "sh", \
             "-c", \
             "exec java -Xmx768m -Xms256m -jar /teamHelathTrack.jar"]