package pl.malopolska.irregularities.convertersFromString;

import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.DocumentBaseIrregularityConverter;
import pl.malopolska.irregularities.dto.DocumentBaseIrregularityDto;
import pl.malopolska.irregularities.services.DocumentBaseIrregularityService;

public class ConverterDocumentBIFromString implements Converter<String, DocumentBaseIrregularityDto> {

    private DocumentBaseIrregularityService documentBaseIrregularityService;
    private DocumentBaseIrregularityConverter documentBaseIrregularityConverter;

    private ConverterDocumentBIFromString(DocumentBaseIrregularityService documentBaseIrregularityService,
                                          DocumentBaseIrregularityConverter documentBaseIrregularityConverter){
        this.documentBaseIrregularityConverter = documentBaseIrregularityConverter;
        this.documentBaseIrregularityService = documentBaseIrregularityService;
    }

    @Override
    public DocumentBaseIrregularityDto convert(String s) {

        return documentBaseIrregularityConverter.convertToDto(documentBaseIrregularityService.getById(Long.parseLong(s)));
    }
}
