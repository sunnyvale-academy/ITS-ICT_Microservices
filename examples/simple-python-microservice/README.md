
Run on Podman Compose
```console
podman compose up --build
```

Deploy on Kubernetes

```console
podman build -t docker.io/dennydgl1/microservices-web .  
podman login 
podman push docker.io/dennydgl1/microservices-web
kubectl apply -f k8s/
```