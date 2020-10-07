package com.example.amazonses.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class EmailList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String emailListName;

//    @Column(nullable = false, updatable = false)
    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Lob
    private String recipientIDs;

    private boolean isActive = true;

}
