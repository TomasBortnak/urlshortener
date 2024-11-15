package com.abatplus.tha.urlshortener.persistance.respository;

import com.abatplus.tha.urlshortener.persistance.entity.UrlEntity;

import lombok.Generated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Generated
@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {
   Optional<UrlEntity> getById(UUID urlId);
}