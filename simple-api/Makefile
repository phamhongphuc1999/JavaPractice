include ../Makefile.mk

## Test.
test:
	mvn test

## Up mongodb using docker. | Docker
mongo:
	docker-compose -f ./docker-compose-mongo.yaml up -d

## Up mysql using docker.
mysql:
	docker-compose -f ./docker-compose-mysql.yaml up -d