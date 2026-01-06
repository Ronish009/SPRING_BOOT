package com.example.dto;

import java.time.LocalDateTime;

public record APIResponse(LocalDateTime timestamp, String message, String details) {

}
