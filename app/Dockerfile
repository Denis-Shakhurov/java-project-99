FROM gradle:8.7.0-jdk21

WORKDIR /

COPY / .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
