FROM gradle:7.5.1-jdk18 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM openjdk:18-slim
EXPOSE 8080
ENV JAVA_OPTS=-Dspring.profiles.active=production
RUN mkdir /app
RUN chown 1000 /app
USER 1000:1000
COPY --chown=1000:1000 --from=build /home/gradle/src/build/libs/app-PROD.jar /app/spring-boot-application.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app/spring-boot-application.jar
