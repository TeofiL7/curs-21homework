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
@Table(name = "YOU_FIND_US")
public class Location {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String city;
    @Column
    private Integer number;
    @Column
    private String street;
    @Column
    private String localInfo;
    @ManyToOne
    @JsonIgnore
    private Gym gym;
}