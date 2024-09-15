FROM gradle:8.7.0-jdk21

WORKDIR /app

COPY /app .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

RUN gradle installBootDist

CMD /app./build/install/app-boot/bin/app --spring.profiles.active=production
