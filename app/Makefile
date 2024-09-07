.DEFAULT_GOAL := build

setup:
	./gradlew wrapper --gradle-version 8.5

run-dist:
	./build/install/java-project-99/bin/java-project-99

run:
	./gradlew bootRun

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

.PHONY: build
