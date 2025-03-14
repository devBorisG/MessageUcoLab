-- Table: language_base_data
CREATE TABLE language_base_data (
    id UUID PRIMARY KEY,
    language VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL
);

-- Table: application_state_data
CREATE TABLE application_state_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: application_data
CREATE TABLE application_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    language_id UUID NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    state_id UUID NOT NULL,
    FOREIGN KEY (language_id) REFERENCES language_base_data(id),
    FOREIGN KEY (state_id) REFERENCES application_state_data(id)
);

-- Table: environment_type_data
CREATE TABLE environment_type_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: environment_state_data
CREATE TABLE environment_state_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: environment_data
CREATE TABLE environment_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    application_id UUID NOT NULL,
    type_id UUID NOT NULL,
    state_id UUID NOT NULL,
    FOREIGN KEY (application_id) REFERENCES application_data(id),
    FOREIGN KEY (type_id) REFERENCES environment_type_data(id),
    FOREIGN KEY (state_id) REFERENCES environment_state_data(id)
);

-- Table: functionality_state_data
CREATE TABLE functionality_state_data (
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
    state_id UUID NOT NULL,
    FOREIGN KEY (application_id) REFERENCES application_data(id),
    FOREIGN KEY (state_id) REFERENCES functionality_state_data(id)
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

-- Table: message_state_data
CREATE TABLE message_state_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
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
    FOREIGN KEY (status_id) REFERENCES message_state_data(id),
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
    environment_id UUID NOT NULL,
    state_data_id UUID NOT NULL,
    FOREIGN KEY (message_id) REFERENCES message_data(id),
    FOREIGN KEY (environment_id) REFERENCES environment_data(id),
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

-- Table: token_state_data
CREATE TABLE token_state_data (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: token_data
CREATE TABLE token_data (
    id VARCHAR PRIMARY KEY,
    secret_name VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    expiration_date TIMESTAMP NOT NULL,
    environment_id UUID NOT NULL,
    state_id UUID NOT NULL,
    FOREIGN KEY (environment_id) REFERENCES environment_data(id),
    FOREIGN KEY (state_id) REFERENCES token_state_data(id)
);