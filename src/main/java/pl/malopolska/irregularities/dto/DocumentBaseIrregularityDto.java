package pl.malopolska.irregularities.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentBaseIrregularityDto {

    private Long id;
    private String name;
    List<IrregularityDto> irregularityDto;

}
