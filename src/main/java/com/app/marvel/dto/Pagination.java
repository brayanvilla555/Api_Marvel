package com.app.marvel.dto;

import lombok.Getter;
import lombok.Setter;

public record Pagination(
        Integer limit,
        Integer offset
) {

}
