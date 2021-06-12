package com.example.CaseStudy.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name="yarn")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Yarn {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer yId;

    @Column(name= "name")
    String yName;

    @Column(name="color")
    String yColor;

    @Column(name="weight")
    Integer yWeight;
}
