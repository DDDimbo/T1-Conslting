FROM amazoncorretto:11
ENV TZ=Europe/Moscow
COPY target/*.jar T1-Conslting.jar
ENTRYPOINT ["java","-jar","/T1-Conslting.jar"]