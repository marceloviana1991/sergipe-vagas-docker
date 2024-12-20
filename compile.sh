#!/bin/bash

docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sergipe-vagas -d mysql
sleep 5
mvn install
docker stop mysql
docker rm mysql
docker rmi mysql