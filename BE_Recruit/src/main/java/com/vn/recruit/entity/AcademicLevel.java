package com.vn.recruit.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "academic_level")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AcademicLevel {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @SequenceGenerator(name = "AL_SEQ", sequenceName = "AL_SEQ", allocationSize = 1, initialValue = 1)
    Long id;

    @Column(name = "code", nullable = false)
    String code;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "is_delete ")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDelete;
}
