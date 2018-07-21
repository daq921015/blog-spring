package top.smartpos.blog.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties
@Component
public class ApplicationProperty {
    private Map<String, String> deploy;

    public Map<String, String> getDeploy() {
        return deploy;
    }

    public void setDeploy(Map<String, String> deploy) {
        this.deploy = deploy;
    }
}
