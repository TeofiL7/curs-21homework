package org.fasttrackit.project;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.project.model.*;
import org.fasttrackit.project.repository.GymRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final GymRepository repository;
    @Override
    public void run(String... args) throws Exception {

        log.info("Runner is populating with data");
        repository.saveAll(List.of(
                Gym.builder()
                        .lastName("Chivu")
                        .firstName("Jhon")
                        .birthDay(LocalDate.of(1985,5,1))
                        .categories(Categories.WORKOUT)
                        .coach(Coach.builder()
                                .name("Zamira")
                                .categories(Categories.WORKOUT)
                                .build())
                        .locations(List.of(Location.builder()
                                .city("Arad")
                                .number(34)
                                .street("Eminescu")
                                .localInfo("subscriptions are not transferable")
                                .build()))

                        .build(),
                Gym.builder()
                        .lastName("Petru")
                        .firstName("Mona")
                        .birthDay(LocalDate.of(1985,5,1))
                        .categories(Categories.FITNESS)
                        .coach(Coach.builder()
                                .name("Zara")
                                .categories(Categories.AEROBIC)
                                .build())
                        .locations(List.of(Location.builder()
                                .city("Bucharest")
                                .number(65)
                                .street("Viteazul")
                                .localInfo("subscriptions are not transferable")
                                .build()))

                        .build(),
                Gym.builder()
                        .lastName("Martin")
                        .firstName("Mona")
                        .birthDay(LocalDate.of(1985,5,1))
                        .categories(Categories.FITNESS)
                        .coach(Coach.builder()
                                .name("Xiuni")
                                .categories(Categories.FITNESS)
                                .build())
                        .locations(List.of(Location.builder()
                                        .city("Oradea")
                                        .number(77)
                                        .street("Petofi")
                                .localInfo("subscriptions are not transferable")
                                .build()))
                        .build()
        ));


    }
}

