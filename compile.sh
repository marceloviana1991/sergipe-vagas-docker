#!/bin/bash

export DB_HOST="localhost"
export DB_PORT="3306"
docker run -p 3306:3306 --name mysql-compile -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sergipe-vagas -d mysql
sleep 5
./mvnw package
docker stop mysql-compile
docker rm mysql-compile
docker rmi mysql
