include ../Makefile.mk

## Build. | Executed command line
buildd:
	mvn clean install

## Run.
run:
	java -cp target/code-1.0-SNAPSHOT.jar com.code.Main

## Build and run.
dev:
	mvn clean install
	java -cp target/code-1.0-SNAPSHOT.jar com.code.Main

## Test.
test:
	mvn test
