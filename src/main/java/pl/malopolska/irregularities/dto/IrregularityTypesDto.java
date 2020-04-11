package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class IrregularityTypesDto {

    private Long id;
    private String name;
    List<IrregularityDto> irregularityDto;

}
