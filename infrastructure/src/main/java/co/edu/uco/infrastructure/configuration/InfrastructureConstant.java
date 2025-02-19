package co.edu.uco.infrastructure.configuration;

public final class InfrastructureConstant {

    private InfrastructureConstant() {}
    public static final String COLLECTION_MONGO_ADAPTER = "airbyte_raw_message";
    public static final String FIELD_MONGO_ADAPTER_ID = "_airbyte_data.id";
    public static final String FIELD_MONGO_ADAPTER_CODE = "_airbyte_data.code";
    public static final String FIELD_MONGO_ADAPTER_TITLE = "_airbyte_data.title";
    public static final String FIELD_MONGO_ADAPTER_CONTENT = "_airbyte_data.content";
    public static final String FIELD_MONGO_ADAPTER_TYPE = "_airbyte_data.type";
    public static final String FIELD_MONGO_ADAPTER_CATEGORY = "_airbyte_data.category";
    public static final String FIELD_MONGO_ADAPTER_STATUS = "_airbyte_data.status";
    public static final String FIELD_MONGO_ADAPTER_APPLICATION = "_airbyte_data.application";
    public static final String FIELD_MONGO_ADAPTER_FUNCTIONALITY = "_airbyte_data.functionality";
    public static final String CORRELATION_ID = "X-Correlation-ID";
    public static final String REDIS_HASH = "Message";
    public static final String DATABASE_MONGO_ADAPTER = "MessageMongoAdapter";
    public static final String CACHE_REDIS_ADAPTER = "MessageRedisAdapter";
    public static final String LOGGING_REQUEST_URI = "REQUEST_URI";
    public static final String LOGGING_HTTP_METHOD = "HTTP_METHOD";
    public static final String LOGGING_SESSION_ID = "JSESSIONID";
    public static final String LOGGING_QUERY_STRING = "QUERY_STRING";
    public static final String LOGGING_PARAMETER_APPLICATION_NAME = "MessageUcoLab";
    public static final String LOGGING_PARAMETER_CODE_MESSAGE = "codeMessage";
    public static final String LOGGING_PARAMETER_APPLICATION = "application";
    public static final String PACKAGE_REPOSITORY_ADAPTER = "co.edu.uco.infrastructure.adapter.secondary.repository";
    public static final String PACKAGE_BASE = "co.edu.uco";
    public static final String LOGGING_TIMESTAMP = "TS";
    public static final String LOGGING_THREAD = "THREAD";
    public static final String LOGGING_APP_NAME = "APP";
    public static final String LOGGING_TRACE_ID = "TRACEID";
    public static final String REQUEST_GET_HEADER_ACCEPT = "Accept";
    public static final String MEDIA_TYPE_DEFAULT = "*/*";
    public static final String JSON_SERIALIZER_CONTENT_TYPE = "application/json";
    public static final String YAML_SERIALIZER_CONTENT_TYPE = "application/yaml";
    public static final String HTML_SERIALIZER_CONTENT_TYPE = "text/html";
    public static final String TEXT_SERIALIZER_CONTENT_TYPE = "text/plain";
    public static final String PATTERN_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
}