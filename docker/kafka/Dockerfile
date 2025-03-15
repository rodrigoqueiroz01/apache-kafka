FROM confluentinc/cp-kafka:6.2.0

USER root

COPY kafka.env /etc/kafka.env
COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

USER appuser

CMD ["/entrypoint.sh"]
