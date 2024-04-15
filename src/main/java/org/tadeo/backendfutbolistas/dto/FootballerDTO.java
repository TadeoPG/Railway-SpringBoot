package org.tadeo.backendfutbolistas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FootballerDTO {

    private Integer idFootballer;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String names;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String lastName;

    private LocalDate birthdate;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String characteristics;

    @NotNull
    private PositionDTO position;
}
