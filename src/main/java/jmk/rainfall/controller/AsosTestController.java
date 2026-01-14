package jmk.rainfall.controller;

import jmk.rainfall.service.KmaAsosClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsosTestController {

    private final KmaAsosClient asosClient;

    public AsosTestController(KmaAsosClient asosClient) {
        this.asosClient = asosClient;
    }

    @GetMapping("/api/test/asos/raw")
    public String raw(
            @RequestParam String tm,
            @RequestParam(defaultValue = "0") int stn,
            @RequestParam(defaultValue = "1") int help
    ) {
        return asosClient.fetchSfctm2Raw(tm, stn, help);
    }
}
