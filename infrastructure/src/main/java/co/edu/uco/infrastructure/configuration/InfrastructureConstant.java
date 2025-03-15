package co.edu.uco.infrastructure.configuration;

public final class InfrastructureConstant {
    private InfrastructureConstant() {
    }
    public static final String COLLECTION_TOKEN = "token";
    public static final String COLLECTION_TOKEN_STATE = "token_state";

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_CREATION_DATE = "creation_date";
    public static final String FIELD_EXPIRATION_DATE = "expiration_date";
    public static final String FIELD_ENVIRONMENT_ID = "environment_id";
    public static final String FIELD_SECRET_NAME = "secret_name";
    public static final String FIELD_STATE_ID = "state_id";
    public static final String ENVIRONMENT_ID_ATTRIBUTE = "environmentId";

    public static final String CORRELATION_ID = "X-Correlation-ID";
    public static final String REDIS_HASH = "Message";
    public static final String DATABASE_MONGO_ADAPTER = "MessageMongoAdapter";
    public static final String CACHE_REDIS_ADAPTER = "MessageRedisAdapter";
    public static final String POSTGRESQL_ADAPTER = "MessagePostgreSQLAdapter";
    public static final String LOGGING_REQUEST_URI = "REQUEST_URI";
    public static final String LOGGING_HTTP_METHOD = "HTTP_METHOD";
    public static final String LOGGING_SESSION_ID = "JSESSIONID";
    public static final String LOGGING_QUERY_STRING = "QUERY_STRING";
    public static final String LOGGING_PARAMETER_APPLICATION_NAME = "MessageUcoLab";
    public static final String LOGGING_PARAMETER_CODE_MESSAGE = "codeMessage";
    public static final String LOGGING_PARAMETER_APPLICATION = "application";
    public static final String PACKAGE_REPOSITORY_ADAPTER = "co.edu.uco.infrastructure.adapter.secondary.repository";
    public static final String PACKAGE_REPOSITORY_POSTGRESQL_ADAPTER = "co.edu.uco.infrastructure.adapter.secondary.repository.postgresql";
    public static final String PACKAGE_BASE = "co.edu.uco";
    public static final String LOGGING_TIMESTAMP = "TS";
    public static final String LOGGING_THREAD = "THREAD";
    public static final String LOGGING_APP_NAME = "APP";
    public static final String LOGGING_TRACE_ID = "TRACEID";
    public static final String REQUEST_GET_HEADER_ACCEPT = "Accept";
    public static final String REQUEST_GET_HEADER_TOKEN = "Token";
    public static final String REQUEST_GET_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String REQUEST_GET_HEADER_AUTHORIZATION = "Authorization";
    public static final String MEDIA_TYPE_DEFAULT = "*/*";
    public static final String JSON_SERIALIZER_CONTENT_TYPE = "application/json";
    public static final String BEARER_TOKEN = "Bearer %s";
    public static final String YAML_SERIALIZER_CONTENT_TYPE = "application/yaml";
    public static final String HTML_SERIALIZER_CONTENT_TYPE = "text/html";
    public static final String TEXT_SERIALIZER_CONTENT_TYPE = "text/plain";
    public static final String XML_SERIALIZER_CONTENT_TYPE = "application/xml";
    public static final String PATTERN_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    public static final String BODY_DOPPLER_CREATE_TOKEN_REQUEST = "{\"project\":\"ucolab\",\"config\":\"dev\",\"change_requests\":[{\"name\":\"%s\",\"originalName\":\"%s\",\"value\":\"%s\"}]}";
    public static final String URL_DOPPLER_CONFIG_SECRETS_POST = "https://api.doppler.com/v3/configs/config/secrets";
    public static final String URL_DOPPLER_CONFIG_SECRETS_GET = "https://api.doppler.com/v3/configs/config/secret?project=ucolab&config=dev&name=%s";
    public static final int PAIR_KEY_SIZE = 2048;
    public static final String ALGORITHM_GENERATE_PAIR_KEY = "RSA";
    public static final String ALGORITHM_PAIR_KEY = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    public static final String DOPPLER_DTO_SECRET_NAME = "secretName";
    public static final String DOPPLER_DTO_PRIVATE_KEY = "privateKey";
    public static final String DOPPLER_DTO_NAME = "name";
    public static final String DOPPLER_DTO_VALUE = "value";
    public static final String DOPPLER_DTO_RAW = "raw";
    public static final String WEB_CONFIG_API_MESSAGE = "/messageucolab/v1/application/**/message/*";
    public static final String WEB_CONFIG_API_APPLICATION = "/messageucolab/v1/application/**/message/*";
    public static final String WEB_CONFIG_API_ENVIRONMENT = "/messageucolab/v1/application/environment";
    public static final String WEB_CONFIG_API_CODE = "/messageucolab/v1/application/code/*";

    public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
    public static final String SWAGGER_UI = "/swagger-ui/**";
    public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
    public static final String SWAGGER_API_DOCS = "/v3/api-docs/**";
    public static final String SWAGGER_WEBJARS = "/webjars/**";
}