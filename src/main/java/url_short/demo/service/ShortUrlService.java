package url_short.demo.service;

import org.springframework.stereotype.Service;
import url_short.demo.model.entity.ShortUrlEntity;
import url_short.demo.repository.ShortUrlRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrlEntity create(String originalUrl) {
        ShortUrlEntity shortUrl = new ShortUrlEntity();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(UUID.randomUUID().toString().substring(0, 6));
        shortUrl.setCreatedAt(LocalDateTime.now());
        shortUrl.setClickCount(0L);

        return shortUrlRepository.save(shortUrl);
    }

    public Optional<ShortUrlEntity> findByShortCode(String shortCode) {
        return shortUrlRepository.findByShortCode(shortCode);
    }
}
