package com.example.holistitimeapi.auth.projection;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public record RefreshTokenResponse(HttpStatus status, Object response) {
}
