# Customers Microservice

![](img/customer-ms.png)

## Prerequisites

Before running the microservice, the following prerequisites must be met:
- Having **Maven** and **Java** (8+) installed 
- **customer-mongodb** Docker container must be started
- **customer-mongodb** host name must resolve to **127.0.0.1** (modify `/etc/hosts` file accordingly), for example:

```
$ cat /etc/hosts | grep 127.0.0.1
127.0.0.1       localhost customer-mongodb
```

## Run microservice

```console
$ mvn exec:exec
```