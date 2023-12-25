package com.burhanmutlu.discributed.project;

import com.burhanmutlu.discributed.project.dto.resp.ProjectResponse;
import com.burhanmutlu.discributed.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
