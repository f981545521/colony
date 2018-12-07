package cn.acyou.colony.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author youfang
 * @version [1.0.0, 2018-12-06 下午 01:14]
 * @since [天天健身/促销模块]
 **/
@Configuration
public class AppConfig {
    @Autowired
    ClusterConfigurationProperties clusterProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
    }
}
