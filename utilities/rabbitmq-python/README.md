# Produce and consumer messages to/from RabbitMQ using Python

## Prerequisites

- Start the Docker Compose file contained in this folder

```console
$ docker-compose up -d 
```

## Run the lab

Install requirements

```console
$ pip install -r requirements.txt   
```

Start the consumer

```console
$ python consumer.py
```

Start the producer

```console
$ python producer.py
```

