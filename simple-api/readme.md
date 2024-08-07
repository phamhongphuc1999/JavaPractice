# Simple api

## Run

-   1. Build project

```shell
make build
```

-   2. Run

```shell
make run
```

-   3. Access

```shell
http://localhost:9090/swagger-ui/index.html
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

-   4. List tables

```shell
SHOW TABLES;
```

-   5. List columns on a table

```shell
SELECT COLUMNS FROM table_name;
```

## Issues

#### can't import packages on VSCode

-   1. Open search box
-   2. Search: Java: clean Java Language Server Workspace
