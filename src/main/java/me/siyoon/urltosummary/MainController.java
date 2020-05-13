package me.siyoon.urltosummary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/")
@RequiredArgsConstructor
public class MainController {
    private final UrlToSummaryService urlToSummaryService;

    @GetMapping
    public ResponseEntity<?> urlToSummary(@RequestParam String url) {
        log.info("URL: {}", url);
        urlToSummaryService.urlToSummary(url);
        return ResponseEntity.ok(url);
    }
}