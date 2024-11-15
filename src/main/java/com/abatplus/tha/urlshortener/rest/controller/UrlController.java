package com.abatplus.tha.urlshortener.rest.controller;

import com.abatplus.tha.urlshortener.mapper.UrlMapper;
import com.abatplus.tha.urlshortener.rest.dto.request.UrlRequestDto;
import com.abatplus.tha.urlshortener.rest.dto.response.UrlResponseDto;
import com.abatplus.tha.urlshortener.service.UrlService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UrlController {

  private final UrlService urlService;
  private final UrlMapper urlMapper;

  @PostMapping("/shortenUrl")
  public ResponseEntity<UrlResponseDto> createShortenUrl(@Valid @RequestBody UrlRequestDto urlRequestDto){
    log.info("Received request to create shorten url: {}", urlRequestDto);
    return ResponseEntity.status(HttpStatus.OK)
        .body(urlMapper.map(urlService.createShortenUrl(urlRequestDto)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Void> getShortenUrl(@PathVariable("id") String id){
    log.info("Received request to get url with id: {}", id);
    UUID urlUuid;
    try {
       urlUuid = UUID.fromString(id);
    } catch (Exception e) {
      log.error("Wrong input parameter: {}", id);
      throw new IllegalArgumentException("Invalid id.");
    }
    String longUrl = urlService.getUrlEntityById(urlUuid).getLongUrl();

    return ResponseEntity.status(HttpStatus.FOUND)
        .location(URI.create(longUrl))
        .build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeShortenUrl(@PathVariable("id") String id){
    log.info("Received request to remove url with id: {}", id);
    UUID urlUuid;
    try {
       urlUuid = UUID.fromString(id);
    } catch (Exception e) {
      log.error("Wrong input parameter: {}", id);
      throw new IllegalArgumentException("Invalid id.");
    }
    urlService.removeUrlEntityById(urlUuid);
    return ResponseEntity.noContent().build();
  }
}
