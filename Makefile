include ./Makefile.mk

## Up Kafka cluster docker using conduktor config. | Docker
conduktor:
	docker-compose -f ./docker/conduktor-docker-compose.yaml up -d

## Up Kafka cluster docker using only redpanda config.
panda:
	docker-compose -f ./docker/redpanda-docker-compose.yaml up -d

## Up MySql database for Event-Driven microservice with Kafka.
edmysql:
	docker-compose -f ./docker/docker-compose-mysql.yaml up -d
