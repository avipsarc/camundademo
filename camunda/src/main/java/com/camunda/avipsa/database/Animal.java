package com.camunda.avipsa.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_table")
public class Animal {
    @Id
    private String animal;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    @Lob
    private byte[] image;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationTimestamp;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updationTimestamp;
}