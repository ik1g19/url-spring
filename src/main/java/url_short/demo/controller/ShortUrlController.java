package url_short.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import url_short.demo.model.dto.CreateShortUrlRequest;
import url_short.demo.model.entity.ShortUrlEntity;
import url_short.demo.service.ShortUrlService;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping
    public ResponseEntity<ShortUrlEntity> createShortUrl(@Valid @RequestBody CreateShortUrlRequest request) {
        ShortUrlEntity saved = shortUrlService.create(request.getOriginalUrl());
        return ResponseEntity.ok(saved);
    }
}
