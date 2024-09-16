FROM gradle:8.7.0-jdk21

WORKDIR /app

COPY /app .
#COPY /app gradle gradle
#COPY /app build.gradle.kts .
#COPY /app settings.gradle.kts .
#COPY /app ./gradlew .

RUN gradle installBootDist

CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
