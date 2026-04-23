package url_short.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import url_short.demo.model.entity.ShortUrlEntity;
import url_short.demo.service.ShortUrlService;

import java.net.URI;
import java.util.Optional;

@RestController
public class RedirectController {

    private final ShortUrlService shortUrlService;

    public RedirectController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        Optional<ShortUrlEntity> shortUrlOpt = shortUrlService.findByShortCode(shortCode);

        if (shortUrlOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ShortUrlEntity shortUrl = shortUrlOpt.get();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(shortUrl.getOriginalUrl()));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
