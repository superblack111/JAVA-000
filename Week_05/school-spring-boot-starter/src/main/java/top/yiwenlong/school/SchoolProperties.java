package top.yiwenlong.school;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {

    private String name;
    private String level;
    private String location;
}
