package com.burhanmutlu.discributed.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.Date;

@Document("users")
//@Sharded(shardKey = {"country","userId"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

   // @Field("userid")
    //private String userId;

    private String name;

    private String username;

    private String password;

    private String country;

    private Date createdAt;

    private Date lastModified;

}
