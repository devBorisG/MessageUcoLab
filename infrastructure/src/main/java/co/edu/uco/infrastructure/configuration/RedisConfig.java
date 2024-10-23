package co.edu.uco.infrastructure.configuration;

import co.edu.uco.infrastructure.adapter.secondary.repository.MessageRedis;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, MessageRedis> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MessageRedis> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType(MessageRedis.class)
                .build();
        objectMapper.activateDefaultTyping(
                ptv,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );

        Jackson2JsonRedisSerializer<MessageRedis> serializer = new Jackson2JsonRedisSerializer<>(objectMapper, MessageRedis.class);
        template.setKeySerializer(new StringRedisSerializer());  // Para claves
        template.setValueSerializer(serializer);  // Para valores (MessageRedis)
        template.afterPropertiesSet();
        return template;
    }
}