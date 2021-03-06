package pl.malopolska.irregularities.convertersFromString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.IrregularityTypesConverter;
import pl.malopolska.irregularities.dto.IrregularityTypesDto;
import pl.malopolska.irregularities.services.IrregularityTypesService;

public class ConverterIrregularityTypeFromString implements Converter<String, IrregularityTypesDto> {

    @Autowired
    private IrregularityTypesService irregularityTypesService;
    @Autowired
    private IrregularityTypesConverter irregularityTypesConverter;

//    public ConverterIrregularityTypeFromString(IrregularityTypesService irregularityTypesService, IrregularityTypesConverter irregularityTypesConverter){
//        this.irregularityTypesConverter = irregularityTypesConverter;
//        this.irregularityTypesService = irregularityTypesService;
//    }

    @Override
    public IrregularityTypesDto convert(String s) {
        return irregularityTypesConverter.convertToDto(irregularityTypesService.getById(Long.parseLong(s)));
    }
}
