docker-compose up -d zookeeper
docker-compose up -d kafka
docker-compose up -d postgres_db
#custoomer+book
docker-compose up -d mongodb_db

#log
docker-compose up -d elasticsearch
docker-compose up -d kibana
docker-compose up -d filebeat
docker-compose up -d logstash


