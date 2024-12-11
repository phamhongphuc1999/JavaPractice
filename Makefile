include ./Makefile.mk

## Up MySql database for Event-Driven microservice with Kafka.
edmysql:
	docker-compose -f ./docker/docker-compose-mysql.yaml up -d
