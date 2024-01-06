package io.github.AndCandido.Very.Useful.Tools.to.Remember.services.impl;

import io.github.AndCandido.Very.Useful.Tools.to.Remember.dtos.requests.ToolRequestDto;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.models.Tool;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.repositories.IToolRepository;
import io.github.AndCandido.Very.Useful.Tools.to.Remember.services.IToolService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToolServiceImpl implements IToolService {

    private IToolRepository toolRepository;

    public ToolServiceImpl(IToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public Tool saveTool(ToolRequestDto toolRequestDto) {
        Tool tool = new Tool();
        BeanUtils.copyProperties(toolRequestDto, tool);
        return toolRepository.save(tool);
    }

    @Override
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    @Override
    public List<Tool> getToolsByTag(List<String> tags) {
        Set<Tool> tools = new HashSet<>();

        for (String tag : tags) {
            List<Tool> toolsFounded = toolRepository.findToolByTag(tag);
            tools.addAll(toolsFounded);
        }

        return tools.stream().toList();
    }

    @Override
    public void deleteToolById(Long id) {
        Tool tool = toolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tool Not Found"));

        toolRepository.delete(tool);
    }
}
