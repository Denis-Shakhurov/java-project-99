FROM gradle:8.7.0-jdk21

COPY / .

WORKDIR /

RUN gradle installBootDist

CMD ./build/install/app-boot/bin/app --spring.profiles.active=production
