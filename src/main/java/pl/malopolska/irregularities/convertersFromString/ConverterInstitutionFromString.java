package pl.malopolska.irregularities.convertersFromString;

import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.InstitutionConverter;
import pl.malopolska.irregularities.dto.InstitutionDto;
import pl.malopolska.irregularities.services.InstitutionService;


public class ConverterInstitutionFromString implements Converter<String, InstitutionDto> {

    private InstitutionService institutionService;
    private InstitutionConverter institutionConverter;

    private ConverterInstitutionFromString(InstitutionService institutionService, InstitutionConverter institutionConverter){
        this.institutionConverter = institutionConverter;
        this.institutionService = institutionService;
    }

    @Override
    public InstitutionDto convert(String id) {
        return institutionConverter.convertToDto(institutionService.getInstitutionByID(Long.parseLong(id)));
    }
}
