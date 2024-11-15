package com.abatplus.tha.urlshortener.service;

import com.abatplus.tha.urlshortener.persistance.entity.UrlEntity;
import com.abatplus.tha.urlshortener.rest.dto.request.UrlRequestDto;

import java.util.UUID;

/**
 * <p>
 * Interface for URL management
 * </p>
 */
public interface UrlService {

  /**
   * Create shorten urlEntity
   *
   * @param dto
   * @return UrlEntity
   */
  UrlEntity createShortenUrl(UrlRequestDto dto);

  /**
   * Retrieve shorten urlEntity by id
   *
   * @param urlId
   * @return UrlEntity
   */
  UrlEntity getUrlEntityById(UUID urlId);

  /**
   * Method removes shorten urlEntity by id
   *
   * @param urlId
   */
  void removeUrlEntityById(UUID urlId);
}