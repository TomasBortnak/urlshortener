package com.abatplus.tha.urlshortener.rest.dto.response;

import com.abatplus.tha.urlshortener.rest.dto.request.UrlRequestDto;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UrlResponseDto extends UrlRequestDto {
    private UUID id;
}