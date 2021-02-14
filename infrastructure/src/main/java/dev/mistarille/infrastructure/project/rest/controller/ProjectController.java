package dev.mistarille.infrastructure.project.rest.controller;

import dev.mistarille.domain.project.ProjectFacade;
import dev.mistarille.domain.project.model.Project;
import dev.mistarille.infrastructure.project.rest.dto.request.CreateProjectRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "project", headers = "X-API-VERSION=0.1.0")
public class ProjectController {

    private final ProjectFacade facade;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity createNewProject(@RequestBody @Valid CreateProjectRequestDto newProjectRequest) {
        Project project = facade.saveProject(UUID.randomUUID(), newProjectRequest.getProjectName());
        return ResponseEntity.of(Optional.of(project));
    }
}
