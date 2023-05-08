package org.fasttrackit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COACH")
public class Coach {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private Categories categories;
    @OneToOne(mappedBy = "coach")
    @JsonIgnore
    private Gym gymOf;

}
