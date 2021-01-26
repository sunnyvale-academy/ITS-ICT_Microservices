kubectl create configmap book-conf --from-file ../book/src/main/resources/application.properties
kubectl create configmap borrow-conf --from-file ../borrow/src/main/resources/application.properties
kubectl create configmap customer-conf --from-file ../customer/src/main/resources/application.properties
kubectl create configmap notification-conf --from-file ../notification/src/main/resources/application.properties

kubectl apply -f book-ms.yaml
kubectl apply -f borrow-ms.yaml
kubectl apply -f customer-ms.yaml
kubectl apply -f notification-ms.yaml