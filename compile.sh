#!/bin/bash

export DB_HOST="localhost"
docker-compose up -d db
sleep 5
mvn install
docker stop mysql-container
docker rm mysql-container
docker rmi mysql
