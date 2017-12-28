FROM java:8-jre
MAINTAINER dulip
RUN mkdir /api
WORKDIR /api
ADD requirements.txt /api/
COPY target/Core-1.0-SNAPSHOT.jar /api/Core.jar
COPY config.yml /api/config.yml
CMD java -jar /api/Core.jar server /api/config.yml
