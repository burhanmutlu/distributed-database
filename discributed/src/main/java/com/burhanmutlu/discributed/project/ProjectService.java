package com.burhanmutlu.discributed.project;

import com.burhanmutlu.discributed.project.dto.req.ProjectRequest;
import com.burhanmutlu.discributed.project.dto.resp.ProjectResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectResponse> getAllProject();

    ProjectResponse getProjectById(String id);

    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectResponse updateProjectById(String id, ProjectRequest projectRequest);

    void deleteProjectById(String id);

}
