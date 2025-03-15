#!/bin/sh
echo "Inicializando Kafka..."
# shellcheck disable=SC2046
# shellcheck disable=SC2002
export $(cat /etc/kafka.env | xargs)
exec /etc/confluent/docker/run
