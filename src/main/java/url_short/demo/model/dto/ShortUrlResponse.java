package url_short.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ShortUrlResponse {
    private Long id;
    private String originalUrl;
    private String shortCode;

    private LocalDateTime createdAt;
    private Long clickCount;
}
