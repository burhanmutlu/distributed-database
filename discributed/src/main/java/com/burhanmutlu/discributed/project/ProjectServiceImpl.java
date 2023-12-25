package com.burhanmutlu.discributed.project;

import com.burhanmutlu.discributed.project.dto.req.ProjectRequest;
import com.burhanmutlu.discributed.project.dto.resp.ProjectResponse;
import com.burhanmutlu.discributed.project.exception.ProjectNotFoundException;
import com.burhanmutlu.discributed.user.User;
import com.burhanmutlu.discributed.user.UserRepository;
import com.burhanmutlu.discributed.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectResponse> getAllProject() {
        List<ProjectResponse> projectResponses = new ArrayList<>();
        projectRepository.findAll().forEach(project -> {
            projectResponses.add(projectMapper.toProjectResponse(project));
        });
        return projectResponses;
    }

    @Override
    public ProjectResponse getProjectById(String id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> {
            throw new ProjectNotFoundException();
        });
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        Project project = projectMapper.toProject(projectRequest);
        project.setCreatedAt(new Date());
        project.setLastModified(new Date());
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProjectById(String id, ProjectRequest projectRequest) {
        Project project = projectRepository.findById(id).orElseThrow(() -> {
            throw new ProjectNotFoundException();
        });
        project = projectMapper.toProject(projectRequest);
        project.setId(id);
        project.setLastModified(new Date());
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void deleteProjectById(String id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> {
            throw new ProjectNotFoundException();
        });
        projectRepository.deleteById(id);
    }
}
