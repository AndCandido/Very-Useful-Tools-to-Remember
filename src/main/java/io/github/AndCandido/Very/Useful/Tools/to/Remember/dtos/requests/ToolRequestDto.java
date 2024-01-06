package io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ToolRequestDto(
    @NotBlank
    String title,
    @NotBlank
    String link,
    @NotBlank
    String description,
    @NotEmpty
    List<String>tags
) {
}
