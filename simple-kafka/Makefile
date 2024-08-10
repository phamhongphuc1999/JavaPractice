include ../Makefile.mk

## Build. | Executed command line
buildd:
	./gradlew clean build -p kafka-basic

## Run.
run:
	./gradlew kafka-basic:run

## Build and run.
dev:
	./gradlew clean build
	./gradlew run

## Up Kafka cluster docker using conduktor config. | Docker
conduktor:
	docker-compose -f ./conduktor-docker-compose.yaml up -d

## Up Kafka cluster docker using only redpanda config.
panda:
	docker-compose -f ./redpanda-docker-compose.yaml up -d
