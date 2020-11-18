package top.yiwenlong.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolContributorAutoConfiguration {

    private final SchoolProperties properties;

    @Autowired
    public SchoolContributorAutoConfiguration(SchoolProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnClass(SchoolImpl.class)
    public ISchool school() {
        return SchoolImpl.builder()
                .name(properties.getName())
                .level(properties.getLevel())
                .location(properties.getLocation())
                .build();
    }
}
