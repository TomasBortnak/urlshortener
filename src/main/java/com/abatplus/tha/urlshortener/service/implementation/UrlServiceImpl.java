package com.abatplus.tha.urlshortener.service.implementation;

import com.abatplus.tha.urlshortener.mapper.UrlMapper;
import com.abatplus.tha.urlshortener.persistance.entity.UrlEntity;
import com.abatplus.tha.urlshortener.persistance.respository.UrlRepository;
import com.abatplus.tha.urlshortener.rest.dto.request.UrlRequestDto;
import com.abatplus.tha.urlshortener.rest.exception.UrlNotFoundException;
import com.abatplus.tha.urlshortener.service.UrlService;

import org.springframework.stereotype.Service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

  private final UrlRepository urlRepository;
  private final UrlMapper urlMapper;

  @Override
  public UrlEntity createShortenUrl(UrlRequestDto dto) {
    return urlRepository.saveAndFlush(urlMapper.map(dto));
  }

  @Override
  public UrlEntity getUrlEntityById(UUID urlId) {
    return urlRepository.getById(urlId)
        .orElseThrow(() -> new UrlNotFoundException(urlId));
  }

  @Override
  public void removeUrlEntityById(UUID urlId) {
    UrlEntity urlEntity = urlRepository.getById(urlId)
        .orElseThrow(() -> new UrlNotFoundException(urlId));
    urlRepository.delete(urlEntity);
  }
}
