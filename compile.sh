#!/bin/bash

export DB_HOST="localhost"
docker run -p 3306:3306 --name mysql-compile -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sergipe-vagas -d mysql
sleep 5
mvn install
docker stop mysql-compile
docker rm mysql-compile
docker rmi mysql
