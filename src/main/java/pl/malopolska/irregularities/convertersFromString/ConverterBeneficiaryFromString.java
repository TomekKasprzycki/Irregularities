package pl.malopolska.irregularities.convertersFromString;

import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.BeneficiaryConverter;
import pl.malopolska.irregularities.dto.BeneficiaryDto;
import pl.malopolska.irregularities.services.BeneficiaryService;

public class ConverterBeneficiaryFromString implements Converter<String, BeneficiaryDto> {

    private BeneficiaryService beneficiaryService;
    private BeneficiaryConverter beneficiaryConverter;

    private ConverterBeneficiaryFromString(BeneficiaryService beneficiaryService, BeneficiaryConverter beneficiaryConverter){
        this.beneficiaryConverter = beneficiaryConverter;
        this.beneficiaryService = beneficiaryService;
    }

    @Override
    public BeneficiaryDto convert(String id) {
        return beneficiaryConverter.convertToDto(beneficiaryService.getBeneficiary(Long.parseLong(id)));
    }
}
