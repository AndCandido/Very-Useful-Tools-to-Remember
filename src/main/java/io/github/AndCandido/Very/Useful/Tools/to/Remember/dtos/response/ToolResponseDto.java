package io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.response;

import io.github.AndCandido.Very.Useful.Tools.to.Remember.models.Tool;

import java.time.LocalDateTime;
import java.util.List;

public record ToolResponseDto(
    Long id,
    String title,
    String link,
    String description,
    List<String>tags,
    LocalDateTime createdAt
) {
    public static ToolResponseDto create(Tool toolSaved) {
        return new ToolResponseDto(
            toolSaved.getId(),
            toolSaved.getTitle(),
            toolSaved.getLink(),
            toolSaved.getDescription(),
            toolSaved.getTags(),
            toolSaved.getCreatedAt()
        );
    }
}
