#!/usr/bin/env bash

cd $(dirname "$0")
if docker ps > /dev/null 2>&1 && docker-compose ps > /dev/null 2>&1; then S=; else S=sudo; fi
export DOCKERHOST=$(ip a | grep -E "([0-9]{1,3}\.){3}[0-9]{1,3}" | grep -v 127.0.0.1 | awk '{ print $2 }' | cut -f1 -d/ | head -n1)
$S docker-compose down