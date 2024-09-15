FROM gradle:8.7.0-jdk21

COPY /app .

WORKDIR /app

RUN gradle installBootDist

CMD /app./build/install/app-boot/bin/app --spring.profiles.active=production
