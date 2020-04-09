package pl.malopolska.irregularities.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.DocumentBaseIrregularityDto;
import pl.malopolska.irregularities.model.DocumentBaseIrregularity;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentBaseIrregularityConverter {

    @Autowired
    private IrregularityConverter irregularityConverter;

    public DocumentBaseIrregularity convertFromDto(DocumentBaseIrregularityDto documentBaseIrregularityDto){
        DocumentBaseIrregularity documentBaseIrregularity = new DocumentBaseIrregularity();
        documentBaseIrregularity.setId(documentBaseIrregularityDto.getId());
        documentBaseIrregularity.setName(documentBaseIrregularityDto.getName());
        //documentBaseIrregularity.setIrregularity(irregularityConverter.convertFromDto(documentBaseIrregularityDto.getIrregularityDto()));

        return documentBaseIrregularity;
    }

    public DocumentBaseIrregularityDto convertToDto(DocumentBaseIrregularity documentBaseIrregularity){
        DocumentBaseIrregularityDto documentBaseIrregularityDto = new DocumentBaseIrregularityDto();
        documentBaseIrregularityDto.setId(documentBaseIrregularity.getId());
        documentBaseIrregularityDto.setName(documentBaseIrregularity.getName());
        //documentBaseIrregularityDto.setIrregularityDto(irregularityConverter.convertToDto(documentBaseIrregularity.getIrregularity()));

        return documentBaseIrregularityDto;
    }

    public List<DocumentBaseIrregularity> convertFromDto(List<DocumentBaseIrregularityDto> documentBaseIrregularityDtoList){
        List<DocumentBaseIrregularity> documentBaseIrregularityList = new ArrayList<>();
        for (DocumentBaseIrregularityDto documentBaseIrregularityDto: documentBaseIrregularityDtoList){
            documentBaseIrregularityList.add(convertFromDto(documentBaseIrregularityDto));
        }
        return documentBaseIrregularityList;
    }

    public List<DocumentBaseIrregularityDto> convertToDto(List<DocumentBaseIrregularity> documentBaseIrregularityList){
        List<DocumentBaseIrregularityDto> documentBaseIrregularityDtoList = new ArrayList<>();
        for (DocumentBaseIrregularity documentBaseIrregularity : documentBaseIrregularityList){
            documentBaseIrregularityDtoList.add(convertToDto(documentBaseIrregularity));
        }
        return documentBaseIrregularityDtoList;
    }

}
