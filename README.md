# microservices-spring

## Нобхідно для запуску додатку:
 - docker
 - docker-compose

```bash
cd microservices-spring // перейти в директорію проекту
docker-compose up --scale client=2 // запустити за допомогою docker-compose
```
wait until all services will be registered in eureka server :)

##### Eureka Server URL: http://localhost:8761
##### Service URL (instance 1): http://localhost:8081
##### Service URL (instance 2): http://localhost:8082
##### Config Server: http://localhost:8888
##### Grafana UI: http://localhost:3000

## For checking refresh:
```bash
docker exec -it containerID /bin/bash
cd /configurations
vi fileName.properties
```
