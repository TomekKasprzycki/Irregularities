package pl.malopolska.irregularities.convertersFromString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.InstitutionConverter;
import pl.malopolska.irregularities.dto.InstitutionDto;
import pl.malopolska.irregularities.services.InstitutionService;


public class ConverterInstitutionFromString implements Converter<String, InstitutionDto> {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private InstitutionConverter institutionConverter;

//    public ConverterInstitutionFromString(InstitutionService institutionService, InstitutionConverter institutionConverter){
//        this.institutionConverter = institutionConverter;
//        this.institutionService = institutionService;
//    }

    @Override
    public InstitutionDto convert(String id) {
        return institutionConverter.convertToDto(institutionService.getInstitutionByID(Long.parseLong(id)));
    }
}
