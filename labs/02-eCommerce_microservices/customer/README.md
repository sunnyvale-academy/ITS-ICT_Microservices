# Customers Microservice

## Run microservice

Before running the microservice, the following prerequisites must be met:
- Having Maven and Java (8+) installed 
- **customer-mongodb** Docker container must be started
- **customer-mongodb** host name must resolve to **127.0.0.1** (modify `/etc/hosts` file accordingly))

```console
$ mvn exec:exec
```