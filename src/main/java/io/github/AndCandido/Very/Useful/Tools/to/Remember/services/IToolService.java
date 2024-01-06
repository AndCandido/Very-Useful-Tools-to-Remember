package io.github.AndCandido.Very.Useful.Tools.to.Remember.services;

import io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.requests.ToolRequestDto;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.models.Tool;

import java.util.List;

public interface IToolService {
    Tool saveTool(ToolRequestDto toolRequestDto);
    List<Tool> getAllTools();
    List<Tool> getToolsByTag(List<String> tags);
    void deleteToolById(Long id);
}
