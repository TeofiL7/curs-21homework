package org.fasttrackit.project.model;

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
@Table(name = "Informations")
public class Information {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String info;
}
