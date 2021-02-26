#!/bin/bash

./apache-tomcat-8.5.60/bin/startup.sh

curl http://localhost:8080/web/service/marvel/characters/ironman

curl http://localhost:8080/web/service/marvel/colaborators/ironman

./apache-tomcat-8.5.60/bin/shutdown.sh
