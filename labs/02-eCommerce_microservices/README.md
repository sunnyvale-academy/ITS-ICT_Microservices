# eCommerce Microservices

![](img/eCommerce.png)

## Prerequisites

- Having completed lab [00 - Prerequisites](../00-Prerequisites/README.md)

## Run microservices containers + infrastructure containers (MongoDB, Zookeeper, Kafka, Postgres)

To compile the classes, start microservices and DBs

```console
$ ./start.sh
```

## Run ONLY infrastructure containers (MongoDB, Zookeeper, Kafka, Postgres)

```console
$ ./start-infra.sh
```


## Customer Microservice details

Open API url [http://localhost:8102/customers-service/v2/api-docs](http://localhost:8102/customers-service/v2/api-docs)

Microservice base url: [http://localhost:8102/customers-service](http://localhost:8102/customers-service)

## Order Microservice details

Open API url [http://localhost:8103/orders-service/v2/api-docs](http://localhost:8103/orders-service/v2/api-docs)

Microservice base url: [http://localhost:8103/orders-service](http://localhost:8103/orders-service)
