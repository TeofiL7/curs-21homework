package org.fasttrackit.project.service;

import jakarta.persistence.Id;
import org.fasttrackit.project.exceptions.ResourceNotFoundException;
import org.fasttrackit.project.model.Gym;
import org.fasttrackit.project.model.Location;
import org.fasttrackit.project.model.filter.MembersFilter;
import org.fasttrackit.project.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private final GymRepository repository;

    public GymService(GymRepository repository) {
        this.repository = repository;
    }
    public List<Gym> getAllMembers(MembersFilter filter) {
        if (filter == null) {
            return repository.findAll();
        }
        return repository.findByFilter(filter.lastName(), filter.firstName());
    }


    public Gym getById(String id) {
        return repository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Member with id %s was not found".formatted(id)));
    }

    public Gym deleteMember(String id) {
        Gym memberToBeDeleted = getById(id);
        repository.deleteById(Integer.valueOf(id));
        return memberToBeDeleted;
    }

    public Gym addNewMember(Gym newMember) {
        return repository.save(newMember);
    }

    public Gym replaceMember(String id, Gym replaceMember) {
       Gym foundMember = getById(id);
       deleteMember(id);
        Gym updateMember = foundMember.toBuilder()
                .id(foundMember.getId())
                .lastName(replaceMember.getLastName())
                .firstName(replaceMember.getFirstName())
                .birthDay(replaceMember.getBirthDay())
                .build();
       repository.save(updateMember);
       return updateMember;
    }

    public Gym addLocation(String id, Location location) {
        Gym gym = getById(id);
        gym.getLocations().add(location);
        return repository.save(gym);
    }
}
