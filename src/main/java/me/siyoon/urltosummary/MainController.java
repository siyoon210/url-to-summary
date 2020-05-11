package me.siyoon.urltosummary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/")
public class MainController {
    @GetMapping
    public ResponseEntity<?> urlToSummary(@RequestParam String url) {
      log.info("URL: {}", url);
      return ResponseEntity.ok(url);
    }
}