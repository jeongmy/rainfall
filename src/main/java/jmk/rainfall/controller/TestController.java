package jmk.rainfall.controller;

import jmk.rainfall.config.KmaProperties;
import jmk.rainfall.service.KmaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final KmaClient kmaClient;
    private final KmaProperties props;

    public TestController(KmaClient kmaClient, KmaProperties props) {
        this.kmaClient = kmaClient;
        this.props = props;
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/kma/key-check")
    public String keyCheck() {
        String key = kmaClient.getApiKey();
        if (key == null || key.isBlank()) return "NO_KEY";
        return "KEY_OK:" + key.substring(0, Math.min(4, key.length())) + "***";
    }

    @GetMapping("/kma/props")
    public String props() {
        return "baseUrl=" + props.getBaseUrl() + ", apiKey=" +
                (props.getApiKey() == null ? "null" : props.getApiKey().substring(0,4) + "***");
    }


}
