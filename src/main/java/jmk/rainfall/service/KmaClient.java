package jmk.rainfall.service;

import jmk.rainfall.config.KmaProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KmaClient {

    private final RestClient restClient;
    private final KmaProperties props;

    public KmaClient(KmaProperties props) {
        this.props = props;
        this.restClient = RestClient.builder()
                .baseUrl(props.getBaseUrl()) // https://apihub.kma.go.kr
                .build();
    }

    public String getRaw(String pathWithQuery) {
        return restClient.get()
                .uri(pathWithQuery)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }

    public String getApiKey() {
        return props.getApiKey();
    }

}
