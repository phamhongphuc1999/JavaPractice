include ../Makefile.mk

## Build. | Executed command line
buildd:
	mvn clean install

## Run.
run:
	mvn spring-boot:run

## Build and run.
dev:
	mvn clean install
	mvn spring-boot:run

## Test.
test:
	mvn test

## Up mongodb using docker. | Docker
mongo:
	docker-compose -f ./docker-compose-mongo.yaml up -d

## Up mysql using docker.
mysql:
	docker-compose -f ./docker-compose-mysql.yaml up -d