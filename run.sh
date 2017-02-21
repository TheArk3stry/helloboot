#! /bin/bash
docker run --name mdb -e MYSQL_ROOT_PASSWORD=slowdive -d mariadb:latest
docker run --name app -d dckard/helloboot:latest
