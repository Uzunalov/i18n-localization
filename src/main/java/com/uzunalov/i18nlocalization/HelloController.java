package com.uzunalov.i18nlocalization;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

    private final MessageService messageService;

    @GetMapping
    @Parameter(description = "Language preference (e.g., en, az, ru)", example = "en",
            in = ParameterIn.HEADER, name = "Accept-Language")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(
                messageService.getMessage("hello", LocaleContextHolder.getLocale()));
    }
}
