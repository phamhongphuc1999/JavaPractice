# Java Practice

## Project

| Id  | Project                                   | Description            |
| :-- | :---------------------------------------- | :--------------------- |
| 1   | [code](./code/)                           | Simple basic java code |
| 2   | [simple-api](./simple-api/)               | Simple java api        |
| 3   | [producer](./producer/)                   | Simple kafka producer  |
| 4   | [consumer](./consumer/)                   | Simple kafka consumer  |
| 5   | [utility](./utility/)                     | Utility                |
| 6   | [order-service](./order-service/)         | Order service          |
| 7   | [inventory-service](./inventory-service/) | Inventory service      |

## Event driven microservices simple app

The app includes project 5, 6 and 7 in the list of projects.

### 1. Setup

-   Ensure you run database already (including creating database and optionally creating tables and initializing data for tables)(read more in the next section).
-   Build [utility](./utility/) first, it is used by others so you alway ensure it is built first.

## Setup database

-   1. Run docker container

```shell
make edmysql
```

-   2. Execute container

```shell
docker exec -it ed_sql_container bash
```

-   3. Login

```shell
mysql -u root -p
```

Then enter `java` as password

-   4. Switch to database

```shell
use java_app;
```

-   5. Check whether tables were created or not

```shell
show tables;
```

if tables were not created, create them.

## Event-driven small app

1. Run kafka server

```shell
make conduktor
```

-   I create kafka by conduktor docker, after running successfully, you can go http://localhost:8080/ to see Conduktor dashboard. (email and password can be modified in `CDK_ADMIN_EMAIL` and `CDK_ADMIN_PASSWORD`)

-   Noticed that Bootstrap server runs in 127.0.0.1:19092

## References

-   https://learn.conduktor.io/kafka/

## Issues

#### can't import packages on VSCode

-   1. Open search box
-   2. Search: Java: clean Java Language Server Workspace
