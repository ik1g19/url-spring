package url_short.demo.mapper;

import url_short.demo.model.dto.ShortUrlResponse;
import url_short.demo.model.entity.ShortUrlEntity;

public class ShortUrlMapper {

    public static ShortUrlResponse toResponse(ShortUrlEntity entity) {
        ShortUrlResponse response = new ShortUrlResponse();
        response.setId(entity.getId());
        response.setOriginalUrl(entity.getOriginalUrl());
        response.setShortCode(entity.getShortCode());
        response.setCreatedAt(entity.getCreatedAt());
        response.setClickCount(entity.getClickCount());
        return response;
    }
}
