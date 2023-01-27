package sg.edu.nus.iss.app.SSF.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

// @Value links to application properties
// ## Local settings. use "set REDISHOST=localhost" and "set REDISPORT=6379" on windows to make this work
// spring.redis.host=${REDISHOST}
// spring.redis.port=${REDISPORT}
// spring.redis.username=
// spring.redis.password=
// spring.redis.client.type=jedis

    // value redis host from appln.properties
    @Value("${spring.redis.host}")
    private String redisHost;

    // value redis port from appln.properties
    @Value("${spring.redis.port}")
    private Optional<Integer> redisPort;

    @Value("${spring.redis.username}")
    private String redisUsername;

    @Value("${spring.redis.password}")
    private String redisPassword;

    // define the return redis template bean as single Object
    // throughout the runtime.
    // Return the RedisTemplate
    @Bean
    @Scope("singleton")
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();

        config.setHostName(redisHost);
        config.setPort(redisPort.get());
        System.out.println(redisUsername);
        System.out.println(redisPassword);

        if (!redisUsername.isEmpty() && !redisPassword.isEmpty()) {
            config.setUsername(redisUsername);
            config.setPassword(redisPassword);
        }
        config.setDatabase(0);

        final JedisClientConfiguration jedisClient = JedisClientConfiguration
                .builder()
                .build();
        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();
        // RedisTemplate<K,V>
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        // associate with the redis connection
        redisTemplate.setConnectionFactory(jedisFac);
        
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // set the map key/value serialization type to String
        redisTemplate.setHashKeySerializer(redisTemplate.getKeySerializer());
        // enable redis to store java object on the value column (Shu Yun)
        RedisSerializer<Object> objSerializer 
                = new JdkSerializationRedisSerializer(getClass().getClassLoader());

        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
