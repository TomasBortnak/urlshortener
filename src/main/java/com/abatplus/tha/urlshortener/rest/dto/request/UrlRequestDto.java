package com.abatplus.tha.urlshortener.rest.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UrlRequestDto {
    @NotNull
    private String longUrl;
    private Long ttl;
}