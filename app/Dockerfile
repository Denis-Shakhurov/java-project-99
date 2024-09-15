FROM gradle:8.7.0-jdk21

COPY /. .
WORKDIR /app

RUN ./gradlew --no-daemon dependencies
RUN ./gradlew --no-daemon build

ENV JAVA_OPTS "-Xmx521M -Xms512M"

CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
