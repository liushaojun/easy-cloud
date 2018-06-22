#!/usr/bin/env bash
docker-compose down
docker images |grep easy-cloud |awk '{print $3}'|xargs docker rmi -f