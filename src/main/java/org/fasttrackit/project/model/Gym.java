package org.fasttrackit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FITNESS_CHECKING_LIST")
public class Gym {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private LocalDate birthDay;

    private Categories categories;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Coach coach;
    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = LAZY)
    private List<Location> locations;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Information information;



}
