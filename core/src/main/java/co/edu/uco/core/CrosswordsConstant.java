package co.edu.uco.core;

public final class CrosswordsConstant {
    private CrosswordsConstant() {}
    public static final String SINGLETON_SCOPE = "singleton";
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
    public static final String LOGGING_REQUEST_URI = "REQUEST_URI";
    public static final String LOGGING_HTTP_METHOD = "HTTP_METHOD";
    public static final String LOGGING_SESSION_ID = "SESSION_ID";
    public static final String LOGGING_QUERY_STRING = "QUERY_STRING";
    public static final String LOGGING_PARAMETER_CODE_MESSAGE = "codeMessage";
    public static final String LOGGING_PARAMETER_APPLICATION = "application";
    public static final String REQUEST_COLUMN_SORT_DEFAULT = "id";
}