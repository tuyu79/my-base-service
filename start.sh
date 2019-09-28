#!/usr/bin/env bash

app_name=my-base-service
image_name=$1

docker rm -f ${app_name}

docker run -d \
     --net=host \
     --restart=always \
     --name  ${app_name}\
     ${image_name}

docker pull 119.3.251.227:5000/my-netty-gateway/master:0.0.3