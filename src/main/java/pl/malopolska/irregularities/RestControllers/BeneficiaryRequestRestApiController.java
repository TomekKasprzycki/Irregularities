package pl.malopolska.irregularities.RestControllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.irregularities.converters.BeneficiaryConverter;
import pl.malopolska.irregularities.dto.BeneficiaryDto;
import pl.malopolska.irregularities.services.BeneficiaryService;

import java.util.List;

@RestController
@RequestMapping("/rest/beneficiary")
public class BeneficiaryRequestRestApiController {

    private BeneficiaryService beneficiaryService;
    private BeneficiaryConverter beneficiaryConverter;

    private BeneficiaryRequestRestApiController(BeneficiaryService beneficiaryService, BeneficiaryConverter beneficiaryConverter){
        this.beneficiaryConverter = beneficiaryConverter;
        this.beneficiaryService = beneficiaryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{nip}")
    public List<BeneficiaryDto> get(@PathVariable("nip") String nip){
        return beneficiaryConverter.convertToDto(beneficiaryService.getBeneficiariesByNIP(nip));
    }

}
