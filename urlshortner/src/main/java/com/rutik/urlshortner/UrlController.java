package com.rutik.urlshortner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class UrlController {

    private final UrlRepo urlRepo;

    UrlController(UrlRepo urlRepo) {
        this.urlRepo = urlRepo;
    }

    // Fixed: matches fetch('/shorten') in index.html
    @PostMapping("/shorten")
    public ResponseEntity<String> add(@RequestBody Map<String, String> longUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl.get("url"));
        mapping = urlRepo.save(mapping);
        String code = Base62Encoder.encode(mapping.getId());
        mapping.setShortCode(code);
        urlRepo.save(mapping);

        return ResponseEntity.ok("http://localhost:8080/" + code);
    }

    // Fixed: added '+' so multi-character codes like /fWO0 work!
    @GetMapping("/{shortCode:[a-zA-Z0-9]+}")
    public ResponseEntity<Object> get(@PathVariable String shortCode) {
        return urlRepo.findByShortCode(shortCode)
                .map(mapping -> ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(mapping.getLongUrl()))
                        .build())
                .orElse(ResponseEntity.notFound().build());
    }
}
