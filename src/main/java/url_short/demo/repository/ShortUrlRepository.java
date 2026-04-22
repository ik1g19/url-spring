package url_short.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import url_short.demo.model.entity.ShortUrlEntity;

import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    Optional<ShortUrlEntity> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);
}
