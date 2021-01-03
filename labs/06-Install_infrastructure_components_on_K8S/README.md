# Deploy microservices on K8S

## Prerequisites

- A working Minikube installation (the one shipped with Docker Desktop or the standalone version)
- The installation of `kubectl` CLI, configured to access the local Minikube cluster (more at https://kubernetes.io/docs/tasks/tools/install-kubectl/ )
- Having installed the Helm client (more at https://helm.sh/docs/intro/install/)

To check `kubectl` configuration, type:

```console
$ kubectl get nodes
NAME             STATUS   ROLES    AGE   VERSION
docker-desktop   Ready    master   10d   v1.16.6-beta.0
```


## Deploy Kafka infrastructure

```console
$ helm repo add bitnami https://charts.bitnami.com/bitnami
"bitnami" has been added to your repositories
```

```console
$ helm install --values kafka-values.yaml kafka bitnami/kafka 
NAME: kafka
LAST DEPLOYED: Sat Jan  2 10:46:55 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
TEST SUITE: None
...
```

To verify that Kafka has been installed correctly:

```console
$ kubectl get pods 
NAME                READY   STATUS    RESTARTS   AGE
kafka-0             1/1     Running   0          55s
kafka-zookeeper-0   1/1     Running   0          56s
...
```

## Deploy ELK infrastructure

Add the elastic Helm repo

```console
$ helm repo add elastic https://helm.elastic.co
"elastic" has been added to your repositories
```

Install Elasticsearch

```console
$ helm install --values elasticsearch-values.yaml elasticsearch elastic/elasticsearch
NAME: elasticsearch
LAST DEPLOYED: Sat Jan  2 11:04:15 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
...
```

To check if Elasticsearch has been started correctly (it may take a while to get Running and Ready):

```console
$ kubectl get pods --namespace=default -l app=elasticsearch-master   
NAME                     READY   STATUS    RESTARTS   AGE
elasticsearch-master-0   1/1     Running   0          6m43s
```

Install Logstash

```console
$ helm install --values logstash-values.yaml logstash elastic/logstash
NAME: logstash
LAST DEPLOYED: Sat Jan  2 11:59:21 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
TEST SUITE: None
...
```

To check if Logstash has been started correctly (it may take a while to get Running and Ready):

```console
$ kubectl get pods --namespace=default -l app=logstash-logstash
NAME                  READY   STATUS    RESTARTS   AGE
logstash-logstash-0   0/1     Running   0          41s
```

Install Filebeat as a DaemonSet

```console
$ helm install --values filebeat-values.yaml filebeat elastic/filebeat
NAME: filebeat
LAST DEPLOYED: Sat Jan  2 12:43:53 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
TEST SUITE: None
...
```

To check if Logstash has been started correctly (it may take a while to get Running and Ready):

```console
$ kubectl get pods --namespace=default -l app=filebeat
NAME                  READY   STATUS    RESTARTS   AGE
logstash-logstash-0   0/1     Running   0          41s
```


## Deploy MongoDB infrastructure

Install MongoDB standalone instance for Customer microservice

```console
$ helm install --values mongodb-values.yaml customer-mongodb bitnami/mongodb
NAME: customer-mongodb
LAST DEPLOYED: Sun Jan  3 09:08:08 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
TEST SUITE: None
...
```

To check if MongoDB has been started correctly (it may take a while to get Running and Ready):

```console
$  kubectl get pods | grep mongo
customer-mongodb-64df6b7549-4ms2r   1/1     Running   0          100s
```

## Deploy PostgreSQL infrastructure

Install PostgreSQL standalone instance for Order microservice

```console
$ helm install --values postgresql-values.yaml order-postgres bitnami/postgresql
NAME: order-postgres
LAST DEPLOYED: Sun Jan  3 09:13:34 2021
NAMESPACE: default
STATUS: deployed
REVISION: 1
TEST SUITE: None
```

To check if PostgreSQL has been started correctly (it may take a while to get Running and Ready):

```console
$  kubectl get pods | grep postgres
order-postgres-0                    1/1     Running   0          4m9s
```

To connect to PostgreSQL from CLI

```console
$ kubectl run order-postgres-client --rm --tty -i --restart='Never' --namespace default --image docker.io/bitnami/postgresql:11.10.0-debian-10-r24 --env="PGPASSWORD=postgres" --command -- psql --host order-postgres -U postgres -d postgres -p 5432
```

