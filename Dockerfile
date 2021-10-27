FROM maven:3.8.3-jdk-11 as maven
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package -DskipTests
FROM openjdk:11-jdk
FROM cockroachdb/cockroach
WORKDIR /my-project
COPY --from=maven target/RestfulApiSpringBoot-0.0.1-SNAPSHOT.jar ./
EXPOSE 8001
CMD ["java", "-jar", "./RestfulApiSpringBoot-0.0.1-SNAPSHOT.jar"]