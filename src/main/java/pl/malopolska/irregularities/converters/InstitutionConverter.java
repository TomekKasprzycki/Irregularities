package pl.malopolska.irregularities.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.InstitutionDto;
import pl.malopolska.irregularities.model.Institution;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionConverter {

    @Autowired
    private UserConverter userConverter;

    public Institution convertFromDto(InstitutionDto institutionDto){
        Institution institution = new Institution();
        institution.setId(institutionDto.getId());
        institution.setName(institutionDto.getName());
        //institution.setUserList(userConverter.convertFromDto(institutionDto.getUserDtoList()));
        return institution;
    }

    public InstitutionDto convertToDto(Institution institution){
        InstitutionDto institutionDto = new InstitutionDto();
        institutionDto.setId(institution.getId());
        institutionDto.setName(institution.getName());
        //institutionDto.setUserDtoList(userConverter.convertToDto(institution.getUserList()));
        return institutionDto;
    }

    public List<InstitutionDto> convertListToDto(List<Institution> institutions){
        List<InstitutionDto> institutionDtoList = new ArrayList<>();
        for (Institution institution : institutions) {
            institutionDtoList.add(convertToDto(institution));
        }
        return institutionDtoList;
    }
}
