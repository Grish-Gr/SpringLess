package maks.ter.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

@JsonDeserialize
public class SearchDto {

    @JsonDeserialize
    LocalDate endDate;


    @JsonDeserialize
    LocalDate startDate;
}
