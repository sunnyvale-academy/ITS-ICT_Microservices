# eCommerce Microservices

![](img/eCommerce.png)

## Prerequisites

- Having completed lab [00 - Prerequisites](../00-Prerequisites/README.md)
- The following host names must resolve to 127.0.0.1 (add them in /etc/hosts file accordingly)
    - customer-mongodb

For example

```
$ cat /etc/hosts | grep 127.0.0.1
127.0.0.1       localhost customer-mongodb
```


To compile the classes, start microservices and DBs

```console
$ ./start.sh
```

## Customer Microservice

Open API url [http://localhost:8102/customers-service/v2/api-docs](http://localhost:8102/customers-service/v2/api-docs)

Microservice base url: [http://localhost:8102/customers-service](http://localhost:8102/customers-service)
