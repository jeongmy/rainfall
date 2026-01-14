package jmk.rainfall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kma")
public class KmaProperties {
    private String apiKey;
    private String baseUrl;
    private String asosPath;

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public String getAsosPath() { return asosPath; }
    public void setAsosPath(String asosPath) { this.asosPath = asosPath; }
}
