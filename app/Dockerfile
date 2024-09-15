FROM gradle:8.7.0-jdk21

WORKDIR /app

COPY /. .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

RUN ./gradlew --no-daemon dependencies
RUN ./gradlew --no-daemon build

ENV JAVA_OPTS "-Xmx521M -Xms512M"

EXPOSE 8080

CMD java -jar build/libs/HexletSpring-1.0-SNAPSHOT.jar
#CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
