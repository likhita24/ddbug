package deltabackend.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="myConfig") 
public class MyConfig {

    private Map<String, String> zipkinUrl = new HashMap<>();
    private List<String> clus = new ArrayList<String>();


    public List<String> getClusters() {
        return clus;
    }

    public void setClusters(List<String> clus) {
        this.clus = clus;
    }

    public Map<String, String> getZipkinUrl() {
        return zipkinUrl;
    }

    public void setZipkinUrl(Map<String, String> zipkinUrl) {
        this.zipkinUrl = zipkinUrl;
    }

}
