package co.edu.uco.infrastructure.configuration;

import co.edu.uco.infrastructure.adapter.secondary.repository.redis.MessageRedis;
import co.edu.uco.utils.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Slf4j
@Configuration
@EnableRedisRepositories(basePackages = {"co.edu.uco.infrastructure.adapter.secondary.repository"})
public class RedisConfig {

    @Bean
    public RedisTemplate<String, MessageRedis> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MessageRedis> template = new RedisTemplate<>();
        try {
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
            template.setKeySerializer(new StringRedisSerializer());
            template.setValueSerializer(serializer);  // Para valores (MessageRedis)
            template.afterPropertiesSet();
        } catch (RedisConnectionFailureException ex) {
            log.error("Failed to connect to Redis", ex);
            throw BusinessException.buildTechnicalException("Failed to connect to Redis");
        } catch (DataAccessException ex) {
            log.error("Data access exception while connecting to Redis", ex);
            throw BusinessException.buildTechnicalException("Data access exception while connecting to Redis");
        } catch (Exception ex) {
            log.error("Unexpected exception while connecting to Redis", ex);
            throw BusinessException.buildTechnicalException("Unexpected exception while connecting to Redis");
        }
        return template;
    }
}