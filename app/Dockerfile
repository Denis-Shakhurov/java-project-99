FROM gradle:8.7.0-jdk21

COPY / .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY src src
WORKDIR /

RUN ./gradlew --no-daemon build

CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
