package org.fasttrackit.project.model.filter;

import lombok.Builder;

@Builder
public record MembersFilter (
        String lastName,
        String firstName
){
}
