FROM amazoncorretto:21
COPY target/*.jar parking-service.jar
ENTRYPOINT ["java","-jar","/parking-service.jar"]