-- Table: application_data
CREATE TABLE application_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: environment_data
CREATE TABLE environment_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    application_id UUID NOT NULL,
    FOREIGN KEY (application_id) REFERENCES application_data(id)
);

-- Table: environment_type
CREATE TABLE environment_type (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: message_category_data
CREATE TABLE message_category_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- Table: message_type_data
CREATE TABLE message_type_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- Table: status_message_data
CREATE TABLE status_message_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: functionality_data
CREATE TABLE functionality_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    application_id UUID NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    FOREIGN KEY (application_id) REFERENCES application_data(id)
);

-- Table: message_data
CREATE TABLE message_data (
    id UUID PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    type_id UUID NOT NULL,
    category_id UUID NOT NULL,
    status_id UUID NOT NULL,
    application VARCHAR(255) NOT NULL,
    functionality_id UUID NOT NULL,
    FOREIGN KEY (type_id) REFERENCES message_type_data(id),
    FOREIGN KEY (category_id) REFERENCES message_category_data(id),
    FOREIGN KEY (status_id) REFERENCES status_message_data(id),
    FOREIGN KEY (functionality_id) REFERENCES functionality_data(id)
);

-- Table: message_environment_state_data
CREATE TABLE message_environment_state_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: message_environment_data
CREATE TABLE message_environment_data (
    id UUID PRIMARY KEY,
    message_id UUID NOT NULL,
    environment_type_id UUID NOT NULL,
    state_data_id UUID NOT NULL,
    FOREIGN KEY (message_id) REFERENCES message_data(id),
    FOREIGN KEY (environment_type_id) REFERENCES environment_type(id),
    FOREIGN KEY (state_data_id) REFERENCES message_environment_state_data(id)
);

-- Table: parameter_data
CREATE TABLE parameter_data (
    id UUID PRIMARY KEY,
    message_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (message_id) REFERENCES message_data(id)
);

-- Table: represent_parameter_data
CREATE TABLE represent_parameter_data (
    id UUID PRIMARY KEY,
    start VARCHAR(255) NOT NULL,
    end_value VARCHAR(255) NOT NULL,
    application_id UUID NOT NULL,
    default_parameter BOOLEAN NOT NULL,
    parameter BOOLEAN NOT NULL,
    FOREIGN KEY (application_id) REFERENCES application_data(id)
);


-- Table: status_token_data
CREATE TABLE status_token_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: token_data
CREATE TABLE token_data (
    id UUID PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    expiration_date TIMESTAMP NOT NULL,
    environment_id UUID NOT NULL,
    FOREIGN KEY (environment_id) REFERENCES environment_data(id)
);

-- Crear un usuario de replicación
CREATE USER crosswords WITH REPLICATION PASSWORD 'crosswords.';
-- Agregar permisos a los schemas
GRANT USAGE ON SCHEMA public TO crosswords;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO crosswords;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO crosswords;

-- Otorgar permisos de replicación a la tabla message
GRANT SELECT ON application_data TO crosswords;
GRANT SELECT ON environment_data TO crosswords;
GRANT SELECT ON environment_type TO crosswords;
GRANT SELECT ON message_category_data TO crosswords;
GRANT SELECT ON message_data TO crosswords;
GRANT SELECT ON message_environment_data TO crosswords;
GRANT SELECT ON message_environment_state_data TO crosswords;
GRANT SELECT ON message_type_data TO crosswords;
GRANT SELECT ON parameter_data TO crosswords;
GRANT SELECT ON represent_parameter_data TO crosswords;
GRANT SELECT ON status_message_data TO crosswords;
GRANT SELECT ON status_token_data TO crosswords;
GRANT SELECT ON token_data TO crosswords;
GRANT SELECT ON functionality_data TO crosswords;

-- Habilitar la replicación lógica
ALTER SYSTEM SET wal_level = logical;
ALTER SYSTEM SET max_replication_slots = 5;
ALTER SYSTEM SET max_wal_senders = 5;

-- Crear una ranura de replicación
SELECT * FROM pg_create_logical_replication_slot('replication_slot', 'pgoutput');

ALTER TABLE message_data REPLICA IDENTITY DEFAULT;
CREATE PUBLICATION airbyte_publication FOR ALL TABLES;

-- Reiniciar el servidor para aplicar los cambios
SELECT pg_reload_conf();