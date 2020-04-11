package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.IrregularityTypesDto;
import pl.malopolska.irregularities.model.IrregularityTypes;
import pl.malopolska.irregularities.services.IrregularitiesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class IrregularityTypesConverter {

    private IrregularityConverter irregularityConverter;
    private IrregularitiesService irregularitiesService;

    private IrregularityTypesConverter(IrregularityConverter irregularityConverter,
                                       IrregularitiesService irregularitiesService){
        this.irregularitiesService = irregularitiesService;
        this.irregularityConverter = irregularityConverter;
    }

    public IrregularityTypes convertFromDto(IrregularityTypesDto irregularityTypesDto){
        IrregularityTypes irregularityType = new IrregularityTypes();
        irregularityType.setId(irregularityTypesDto.getId());
        irregularityType.setName(irregularityTypesDto.getName());
        irregularityType.setIrregularityList(irregularitiesService.getAllByIrregularityTypesId(irregularityTypesDto.getId()));

        return irregularityType;
    }

    public IrregularityTypesDto convertToDto(IrregularityTypes irregularityTypes){
        IrregularityTypesDto irregularityTypeDto = new IrregularityTypesDto();
        irregularityTypeDto.setId(irregularityTypes.getId());
        irregularityTypeDto.setName(irregularityTypes.getName());
        irregularityTypeDto.setIrregularityDto(irregularityConverter.convertToDto(irregularityTypes.getIrregularityList()));

        return irregularityTypeDto;
    }

    public List<IrregularityTypes> convertFromDto(List<IrregularityTypesDto> irregularityTypesDtoList){
        List<IrregularityTypes> irregularityTypesList = new ArrayList<>();
        for (IrregularityTypesDto irregularityDto : irregularityTypesDtoList) {
            irregularityTypesList.add(convertFromDto(irregularityDto));
        }
        return irregularityTypesList;
    }

    public List<IrregularityTypesDto> convertToDto(List<IrregularityTypes> irregularityTypesList){
        List<IrregularityTypesDto> irregularityTypesDtoList = new ArrayList<>();
        for (IrregularityTypes irregularity : irregularityTypesList) {
            irregularityTypesDtoList.add(convertToDto(irregularity));
        }
        return irregularityTypesDtoList;
    }
}
