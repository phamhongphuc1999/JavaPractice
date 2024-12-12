# Java Practice

## Project

| Id  | Project                           | Description            |
| :-- | :-------------------------------- | :--------------------- |
| 1   | [simple-api](./simple-api/)       | Simple java api        |
| 2   | [code](./code/)                   | Simple basic java code |
| 3   | [utility](./utility/)             | Utility                |
| 4   | [Order service](./order-service/) | Order service          |

## Event driven microservices simple app

The app includes project 3, 4 in the list of projects.

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
