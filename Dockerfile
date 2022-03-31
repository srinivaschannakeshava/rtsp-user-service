FROM adoptopenjdk:11.0.11_9-jre-hotspot-focal
RUN groupadd -g 1000 spring && useradd --shell /bin/bash -u 1000 -g 1000 -m spring
RUN mkdir -p logs  && chown -R spring:spring logs 
ENV jasypt.encryptor.password=s3cret
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Djasypt.encryptor.password=s3cret","/app.jar"]