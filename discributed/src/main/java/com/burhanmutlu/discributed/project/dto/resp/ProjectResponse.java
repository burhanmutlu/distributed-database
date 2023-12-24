package com.burhanmutlu.discributed.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

    private String id;
    private String name;
    private String description;
    private Date createdAt;
    private Date lastModified;

}
