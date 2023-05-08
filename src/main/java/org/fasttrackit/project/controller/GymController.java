package org.fasttrackit.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.project.model.Location;
import org.fasttrackit.project.model.dto.GymDTO;
import org.fasttrackit.project.model.dto.GymMapper;
import org.fasttrackit.project.model.filter.MembersFilter;
import org.fasttrackit.project.service.GymService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.project.model.dto.GymMapper.toDto;
import static org.fasttrackit.project.model.dto.GymMapper.toEntity;

@RestController
@RequestMapping("gym")
@RequiredArgsConstructor
@Slf4j
public class GymController {
    private final GymService service;
    private final GymMapper mapper;

    @GetMapping // http://localhost:7777/gym
    public List<GymDTO> getAllMembers(MembersFilter filter){
        log.info("GET all members was called");
        return service.getAllMembers(filter).stream()
                .map(GymMapper::toDto)
                .toList();

    }

    @GetMapping("{id}")
    public GymDTO getById(@PathVariable String id){
        log.info("GET member by id");
        return toDto(service.getById(id));
    }

    @DeleteMapping("{id}")
    public GymDTO deleteMemberById(@PathVariable String id){
        log.info("DELETE member by id");
        return toDto(service.deleteMember(id));
    }

    @PostMapping
    public GymDTO addNewMember(@RequestBody GymDTO newMember){
        log.info("POST add new member");
        return toDto(service.addNewMember(toEntity(newMember)));
    }

    @PutMapping("{id}")
    public GymDTO replaceMember(@PathVariable String id, @RequestBody GymDTO replaceMember){
        log.info("PUT replace a member");
        return toDto(service.replaceMember(id, toEntity(replaceMember)));
    }

    @PostMapping("{id}/locations") // http://localhost:7777/gym/{id}/locations
    public GymDTO addNewLocation(@PathVariable String id ,@RequestBody Location location){
        log.info("POST add new location");
        return toDto(service.addLocation(id, location));
    }
}
