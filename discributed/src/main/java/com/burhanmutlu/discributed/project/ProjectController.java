package com.burhanmutlu.discributed.project;

import com.burhanmutlu.discributed.project.dto.req.ProjectRequest;
import com.burhanmutlu.discributed.project.dto.resp.ProjectResponse;
import com.burhanmutlu.discributed.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse projectResponse = projectService.createProject(projectRequest);
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponse>> getAllProject() {
        List<ProjectResponse> projectResponses = projectService.getAllProject();
        return ResponseEntity.ok(projectResponses);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable String id) {
        ProjectResponse projectResponse = projectService.getProjectById(id);
        return ResponseEntity.ok(projectResponse);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<ProjectResponse> updateProjectById(@PathVariable String id,
                                                             @RequestBody ProjectRequest projectRequest) {
        ProjectResponse projectResponse = projectService.updateProjectById(id, projectRequest);
        return ResponseEntity.ok(projectResponse);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<GenericResponse> deleteProjectById(@PathVariable String id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok(new GenericResponse(true, "Project is deleted"));
    }

}
