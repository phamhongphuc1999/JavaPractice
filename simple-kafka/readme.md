## Kafka

### Start Zookeeper and Kafka

1. Start Zookeeper

```shell
zookeeper-server-start.sh ~/kafka-folder/config/zookeeper.properties
```

2. Start Kafka server

```shell
kafka-server-start.sh ~/kafka-folder/config/server.properties
```

### Start KRaft and Kafka

1. Generate UUID for cluster

```shell
kafka-storage.sh random-uuid
```

2. Config server id

```shell
kafka-storage.sh format -t <uuid> -c ~/Documents/kafka-folder/config/kraft/server.properties
```

3. Start Kafka server without Zookeeper

```shell
kafka-server-start.sh ~/kafka-folder/config/kraft/server.properties
```

### Run simple Kafka cluster using conduktor config

1. Deploy and run kafka cluster with docker

```shell
make conduktor
```

2. Go to `http://localhost:8080` and login

### Run simple Kafka cluster using only redpanda config

1. Deploy and run kafka cluster with docker

```shell
make panda
```

2. Go to `http://localhost:8080`
