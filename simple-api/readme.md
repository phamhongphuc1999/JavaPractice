# Simple api

## Run

-   1. Build project

```shell
mvn clean install
```

-   2. Run

```shell
mvn spring-boot:run
```

## Database mysql testing

-   1. Execute database docker container

```shell
docker exec -it dev_java_sql_container bash
```

-   2. Login

```shell
mysql -u root -p
```

-   3. Using java_app database

```shell
use java_app;
```
