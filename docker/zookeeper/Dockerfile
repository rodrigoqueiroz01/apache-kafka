FROM confluentinc/cp-zookeeper:latest

COPY zookeeper.env /etc/zookeeper.env

CMD ["sh", "-c", "export $(cat /etc/zookeeper.env | xargs) && /etc/confluent/docker/run"]