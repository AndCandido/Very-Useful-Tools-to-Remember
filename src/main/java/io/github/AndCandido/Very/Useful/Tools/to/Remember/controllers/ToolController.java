package io.github.AndCandido.Very.Useful.Tools.to.Remember.controllers;

import io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.requests.ToolRequestDto;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.response.ToolResponseDto;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.models.Tool;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.services.IToolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public record ToolController(
    IToolService toolService
) {

    @PostMapping
    public ResponseEntity<ToolResponseDto> saveTool(
        @RequestBody @Valid ToolRequestDto toolRequestDto
    ) {
        Tool toolSaved = toolService.saveTool(toolRequestDto);
        ToolResponseDto toolResponseDto = ToolResponseDto.create(toolSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(toolResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ToolResponseDto>> getAllTools() {
        List<ToolResponseDto> toolResponseDtoList = toolService.getAllTools()
            .stream()
            .map(ToolResponseDto::create)
            .toList();

        return ResponseEntity.ok(toolResponseDtoList);
    }

    @GetMapping(params = "tag")
    public ResponseEntity<List<ToolResponseDto>> getToolsByTag(
        @RequestParam("tag") List<String> tags
    ) {
        List<ToolResponseDto> toolResponseDtoList = toolService.getToolsByTag(tags)
            .stream()
            .map(ToolResponseDto::create)
            .toList();

        return ResponseEntity.ok(toolResponseDtoList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteToolById(
        @PathVariable Long id
    ) {
        try {
            toolService.deleteToolById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
