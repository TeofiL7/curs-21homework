package org.fasttrackit.project.model.dto;

import lombok.Builder;
import org.fasttrackit.project.model.*;

import java.time.LocalDate;
import java.util.List;

@Builder
public record GymDTO (
        Integer id,
        String lastName,
        String firstName,
        LocalDate birthDay,
        Categories categories,
        Coach coach,
        List<Location> location,
        Information information
){
}
