export DOCKER_CLIENT_TIMEOUT=120
export COMPOSE_HTTP_TIMEOUT=120

cd customer
mvn clean && mvn package
docker-compose up --build
cd ..