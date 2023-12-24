package com.burhanmutlu.discributed.project;

import com.burhanmutlu.discributed.project.dto.req.ProjectRequest;
import com.burhanmutlu.discributed.project.dto.resp.ProjectResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponse toProjectResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .lastModified(project.getLastModified())
                .createdAt(project.getCreatedAt())
                .build();
    }

    public Project toProject(ProjectRequest projectRequest) {
        return Project.builder()
                .name(projectRequest.getName())
                .description(projectRequest.getDescription())
                .build();
    }

}
