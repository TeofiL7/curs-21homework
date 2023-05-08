package org.fasttrackit.project.repository;

import org.fasttrackit.project.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
    @Query("select g from Gym g where (g.lastName=:lastName or :lastName is null ) " +
            "and (g.firstName>= :firstName or :firstName is null)")
    List<Gym> findByFilter(String lastName, String firstName);
}
