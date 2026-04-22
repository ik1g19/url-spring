package url_short.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateShortUrlRequest {

    @NotBlank
    private String originalUrl;

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
