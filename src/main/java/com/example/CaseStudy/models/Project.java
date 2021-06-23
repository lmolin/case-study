package com.example.CaseStudy.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long pId;

    @Column(name="name")
    String pName;

    @ManyToMany
    @JoinTable(name= "projectyarn",
            joinColumns = @JoinColumn(name = "pId"),
            inverseJoinColumns = @JoinColumn(name = "yId"))
    List<Yarn> pYarn;

    @Column(name="description")
    String pDesc;

}
