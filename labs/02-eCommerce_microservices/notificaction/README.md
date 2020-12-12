# Notification Microservice

![](img/notification-ms.png)

## Prerequisites

Before running the microservice, the following prerequisites must be met:
- Having **Maven** and **Java** (8+) installed 
- **Zookeeper** and **Kafka** Docker containers must be started
- **kafka** host name must resolve to **127.0.0.1** (modify `/etc/hosts` file accordingly), for example:

```
$ cat /etc/hosts | grep 127.0.0.1
127.0.0.1       localhost kafka
```

## Run microservice

```console
$ mvn exec:exec
```