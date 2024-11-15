package com.abatplus.tha.urlshortener.mapper;

import com.abatplus.tha.urlshortener.persistance.entity.UrlEntity;
import com.abatplus.tha.urlshortener.rest.dto.request.UrlRequestDto;
import com.abatplus.tha.urlshortener.rest.dto.response.UrlResponseDto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class UrlMapper {

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public abstract UrlEntity map(UrlRequestDto dto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public abstract UrlResponseDto map(UrlEntity dto);
}