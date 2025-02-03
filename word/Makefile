include ../Makefile.mk

## Remove database.
remove:
	rm -rf sql/mysql-data
	mkdir sql/mysql-data

## Test.
test:
	mvn test

## Up mysql using docker.
mysql:
	docker compose -f ./docker-compose-mysql.yaml up -d
