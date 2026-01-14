package jmk.rainfall.service;

import jmk.rainfall.config.KmaProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KmaAsosClient {

    private final RestClient restClient;
    private final KmaProperties props;

    public KmaAsosClient(KmaProperties props) {
        this.props = props;
        this.restClient = RestClient.builder()
                .baseUrl(props.getBaseUrl()) // https://apihub.kma.go.kr
                .build();
    }

    /**
     * ASOS 시간자료(sfctm2) raw 응답을 그대로 가져옴.
     * tm 형식: yyyyMMddHHmm (예: 202211300900)
     * stn: 지점번호(0이면 전체/기능은 문서 확인 필요)
     * help=1이면 헤더/설명 포함 응답이 오는 편(파싱 확인에 좋음)
     */
    public String fetchSfctm2Raw(String tm, int stn, int help) {
        String uri = UriComponentsBuilder
                .fromPath("/api/typ01/url/kma_sfctm2.php")
                .queryParam("tm", tm)
                .queryParam("stn", stn)
                .queryParam("help", help)
                .queryParam("authKey", props.getApiKey())
                .build(true)
                .toUriString();

        return restClient.get()
                .uri(uri)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .body(String.class);
    }
}
