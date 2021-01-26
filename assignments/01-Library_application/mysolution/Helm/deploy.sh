helm repo add bitnami https://charts.bitnami.com/bitnami
helm install --values kafka-values.yaml kafka bitnami/kafka
helm repo add elastic https://helm.elastic.co
helm install --values elasticsearch-values.yaml elasticsearch elastic/elasticsearch
helm install --values logstash-values.yaml logstash elastic/logstash
helm install --values filebeat-values.yaml filebeat elastic/filebeat
helm install --values kibana-values.yaml kibana elastic/kibana
helm install --values customer-mongodb-values.yaml customer-mongodb bitnami/mongodb
helm install --values book-mongodb-values.yaml book-mongodb bitnami/mongodb
helm install --values postgresql-values.yaml borrow-postgres bitnami/mongodb