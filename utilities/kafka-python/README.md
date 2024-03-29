# Produce and consumer messages to/from Kafka using Python

## Prerequisites

- To have started Kafka using Docker Compose as showed in the lab [02-eCommerce_microservices](../../labs/02-eCommerce_microservices/README.md)
- On the host, to have mapped localhost and kafka to 127.0.0.1, for example

```bash
$ echo "127.0.0.1 kafka localhost" | sudo tee -a /etc/hosts)
```

## Run the lab

Install dependencies

```console
$ pip install -r requirements.txt
```

Start consumer

```console
$ python kafka-consumer.py --config_file consumer.conf
```

Produce messages

```console
$ python kafka-producer.py --config_file producer.conf
```

In the case you want to consume from the beginning of the topic/partition

```console
$ python kafka-consumer.py --config_file consumer.conf --reset
```
