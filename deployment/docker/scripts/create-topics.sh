#!/bin/bash

echo "Waiting for Kafka to be ready..."
cub kafka-ready -b kafka:9092 1 120

echo "Creating Kafka topics..."

# Lista de tópicos a crear
topics=(
  "postgres.public.application_data"
  "postgres.public.application_state_data"
  "postgres.public.environment_data"
  "postgres.public.environment_state_data"
  "postgres.public.environment_type_data"
  "postgres.public.functionality_data"
  "postgres.public.functionality_state_data"
  "postgres.public.language_base_data"
  "postgres.public.message_category_data"
  "postgres.public.message_data"
  "postgres.public.message_environment_data"
  "postgres.public.message_environment_state_data"
  "postgres.public.message_state_data"
  "postgres.public.message_type_data"
  "postgres.public.parameter_data"
  "postgres.public.represent_parameter_data"
  "postgres.public.token_data"
  "postgres.public.token_state_data"
)

# Crear cada tópico
for topic in "${topics[@]}"; do
  echo "Creating topic: $topic"
  kafka-topics --create --if-not-exists --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1 --topic "$topic"
done

echo "All Kafka topics created successfully."