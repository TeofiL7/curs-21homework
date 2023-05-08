package org.fasttrackit.project.model.dto;

import org.fasttrackit.project.model.Gym;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {
    public static GymDTO toDto(Gym entity){
        return GymDTO.builder()
                .id(entity.getId())
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .birthDay(entity.getBirthDay())
                .categories(entity.getCategories())
                .coach(entity.getCoach())
                .location(entity.getLocations())
                .information(entity.getInformation())
                .build();
    }

    public static Gym toEntity(GymDTO gymDTO){
        return Gym.builder()
                .id(gymDTO.id())
                .lastName(gymDTO.lastName())
                .firstName(gymDTO.firstName())
                .birthDay(gymDTO.birthDay())
                .categories(gymDTO.categories())
                .coach(gymDTO.coach())
                .locations(gymDTO.location())
                .information(gymDTO.information())
                .build();
    }
}
