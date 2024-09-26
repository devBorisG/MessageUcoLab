package co.edu.uco.infrastructure.configuration;

import co.edu.uco.core.domain.MessageRedis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, MessageRedis> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MessageRedis> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Configuramos ObjectMapper para serializar/deserializar JSON sin @class
        ObjectMapper objectMapper = new ObjectMapper();
        // Usamos GenericJackson2JsonRedisSerializer para serializar con el ObjectMapper
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper);
        template.setKeySerializer(new StringRedisSerializer());  // Para claves
        template.setValueSerializer(serializer);  // Para valores (MessageRedis)
        template.afterPropertiesSet();
        return template;
    }
}