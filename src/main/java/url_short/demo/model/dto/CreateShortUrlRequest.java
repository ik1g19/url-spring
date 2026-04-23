package url_short.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateShortUrlRequest {

    @NotBlank
    private String originalUrl;

}
