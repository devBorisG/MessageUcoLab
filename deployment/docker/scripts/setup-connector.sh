#!/bin/bash

echo " Esperando a que Kafka Connect esté disponible..."
while ! curl -s http://connect:8083/connectors; do
    sleep 5
    echo "⏳ Kafka Connect aún no está listo - esperando..."
done

echo "✅ Kafka Connect está listo. Registrando conector de PostgreSQL..."

curl -X POST -H 'Content-Type: application/json' --data @/connector-postgres.json http://connect:8083/connectors

echo "✅ Conector registrado correctamente."