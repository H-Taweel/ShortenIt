package com.redi.shortener.repository;

import com.redi.shortener.persistence.URLShortened;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLShortenerRepository extends JpaRepository<URLShortened, Long> {
  URLShortened getURLShortenedByKey(String key);

  List<URLShortened> getURLShortenedByUrl(String url);
}
