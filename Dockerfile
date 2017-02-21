#Use openjdk-8 image tu run
FROM openjdk:8-jdk-alpine
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
#Use port 8080
EXPOSE 8080
#Set path variables
#RUN echo "export JAVA_HOME=/usr/lib/jvm/java-1.7-openjdk" >> ~/.bashrc
#Run .mvnw
CMD ["./mvnw","spring-boot:run"]

