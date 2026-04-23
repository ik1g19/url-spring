package url_short.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import url_short.demo.mapper.ShortUrlMapper;
import url_short.demo.model.dto.CreateShortUrlRequest;
import url_short.demo.model.dto.ShortUrlResponse;
import url_short.demo.model.entity.ShortUrlEntity;
import url_short.demo.service.ShortUrlService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/urls")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping
    public ResponseEntity<ShortUrlResponse> createShortUrl(@Valid @RequestBody CreateShortUrlRequest request) {
        ShortUrlEntity saved = shortUrlService.create(request.getOriginalUrl());
        return ResponseEntity.ok(ShortUrlMapper.toResponse(saved));
    }
}
