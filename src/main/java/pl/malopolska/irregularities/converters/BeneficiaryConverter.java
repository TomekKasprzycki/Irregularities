package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.BeneficiaryDto;
import pl.malopolska.irregularities.model.Beneficiary;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryConverter {

    private ProjectConverter projectConverter;

    private BeneficiaryConverter(ProjectConverter projectConverter){
        this.projectConverter = projectConverter;
    }

    public BeneficiaryDto convertToDto(Beneficiary beneficiary){
        BeneficiaryDto beneficiaryDto = new BeneficiaryDto();
        beneficiaryDto.setId(beneficiary.getId());
        beneficiaryDto.setName(beneficiary.getName());
        beneficiaryDto.setNip(beneficiary.getNip());
        beneficiaryDto.setProjectDto(projectConverter.convertToDto(beneficiary.getProjectList()));

        return beneficiaryDto;
    }

    public Beneficiary convertFromDto(BeneficiaryDto beneficiaryDto){
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(beneficiaryDto.getId());
        beneficiary.setName(beneficiaryDto.getName());
        beneficiary.setNip(beneficiaryDto.getNip());
        beneficiary.setProjectList(projectConverter.convertFromDto(beneficiaryDto.getProjectDto()));

        return beneficiary;
    }


    public List<BeneficiaryDto> convertToDto(List<Beneficiary> beneficiaries){
        List<BeneficiaryDto> beneficiariesDtoList = new ArrayList<>();
        for (Beneficiary beneficiary : beneficiaries) {
            beneficiariesDtoList.add(convertToDto(beneficiary));
        }
        return beneficiariesDtoList;
    }

    public List<Beneficiary> convertFromDto(List<BeneficiaryDto> beneficiariesDto){
        List<Beneficiary> beneficiariesList = new ArrayList<>();
        for (BeneficiaryDto beneficiaryDto : beneficiariesDto) {
            beneficiariesList.add(convertFromDto(beneficiaryDto));
        }
        return beneficiariesList;
    }


}
