FROM openjdk:11

ARG JarFile=target/RestfulApiSpringBoot-0.0.1-SNAPSHOT.jar

WORKDIR /opt/restapi

COPY ${JarFile} restapi.jar

ENTRYPOINT ["java","-jar","restapi.jar"]