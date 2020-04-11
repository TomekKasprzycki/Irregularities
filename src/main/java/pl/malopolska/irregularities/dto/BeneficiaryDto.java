package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class BeneficiaryDto {

    private Long id;
    private String name;
    private String nip;
    List<ProjectDto> projectDto;

}
