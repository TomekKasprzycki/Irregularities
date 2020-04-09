package pl.malopolska.irregularities.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.IrregularityDto;
import pl.malopolska.irregularities.model.Irregularity;
import pl.malopolska.irregularities.services.DocumentBaseIrregularityService;
import pl.malopolska.irregularities.services.IrregularityTypesService;
import pl.malopolska.irregularities.services.PaymentRequestService;
import pl.malopolska.irregularities.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class IrregularityConverter {

    @Autowired
    private PaymentRequestConverter paymentRequestConverter;

    @Autowired
    private DocumentBaseIrregularityConverter dbic;

    @Autowired
    private IrregularityTypesConverter irregularityTypesConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentBaseIrregularityService dbis;

    @Autowired
    private IrregularityTypesService its;

    @Autowired
    private PaymentRequestService prs;


    public Irregularity convertFromDto(IrregularityDto irregularityDto){
        Irregularity irregularity = new Irregularity();
        irregularity.setId(irregularityDto.getId());
        irregularity.setActual(irregularityDto.isActual());
        irregularity.setCAHasEnded(irregularityDto.isCAHasEnded());
        irregularity.setCaseID(irregularityDto.getCaseID());
        irregularity.setClosedByIB(irregularityDto.getClosedByIB());
        irregularity.setClosedByMA(irregularityDto.getClosedByMA());
        irregularity.setContractingInstitutionNIP(irregularityDto.getContractingInstitutionNIP());
        irregularity.setContractReferenceNumber(irregularityDto.getContractReferenceNumber());
        irregularity.setCreator(userService.getUserById(irregularityDto.getCreatorId()));
        irregularity.setTotalExpenses(irregularityDto.getTotalExpenses());
        irregularity.setQualifiedExpenses(irregularityDto.getQualifiedExpenses());
        irregularity.setDetectedBeforeSendToEC(irregularityDto.isDetectedBeforeSendToEC());
        irregularity.setDocumentBaseIrregularity(dbis.getById(irregularityDto.getDocumentBaseIrregularityId()));
        irregularity.setDateOfIrregularity(irregularityDto.getDateOfIrregularity());
        irregularity.setDescription(irregularityDto.getDescription());
        irregularity.setCaseID(irregularityDto.getCaseID());
        irregularity.setNotes(irregularityDto.getNotes());
        irregularity.setVisibleToCA(irregularityDto.isVisibleToCA());
        irregularity.setPaymentRequestList(prs.getAllByIrregularityId(irregularityDto.getId()));
        irregularity.setCreated(irregularityDto.getCreated());
        irregularity.setIrregularityTypesList(its.getAllByIrregularityId(irregularityDto.getId()));
        //irregularity.setDocumentBaseIrregularity(dbic.convertFromDto(irregularityDto.getDocumentBaseIrregularityDto()));

        return irregularity;
    }

    public IrregularityDto convertToDto(Irregularity irregularity){
        IrregularityDto irregularityDto = new IrregularityDto();
        irregularityDto.setId(irregularity.getId());
        irregularityDto.setActual(irregularity.isActual());
        irregularityDto.setCAHasEnded(irregularity.isCAHasEnded());
        irregularityDto.setCaseID(irregularity.getCaseID());
        irregularityDto.setClosedByIB(irregularity.getClosedByIB());
        irregularityDto.setClosedByMA(irregularityDto.getClosedByMA());
        irregularityDto.setContractingInstitutionNIP(irregularity.getContractingInstitutionNIP());
        irregularityDto.setContractReferenceNumber(irregularity.getContractReferenceNumber());
        irregularityDto.setCreatorId(irregularity.getCreator().getId());
        irregularityDto.setTotalExpenses(irregularity.getTotalExpenses());
        irregularityDto.setQualifiedExpenses(irregularity.getQualifiedExpenses());
        irregularityDto.setDetectedBeforeSendToEC(irregularity.isDetectedBeforeSendToEC());
        irregularityDto.setDocumentBaseIrregularityId(irregularity.getDocumentBaseIrregularity().getId());
        irregularityDto.setDateOfIrregularity(irregularity.getDateOfIrregularity());
        irregularityDto.setDescription(irregularity.getDescription());
        irregularityDto.setCaseID(irregularity.getCaseID());
        irregularityDto.setNotes(irregularity.getNotes());
        irregularityDto.setVisibleToCA(irregularity.isVisibleToCA());
        //irregularityDto.setPaymentRequestDtoList(paymentRequestConverter.convertToDto(irregularity.getPaymentRequestList()));
        irregularityDto.setCreated(irregularity.getCreated());
        //irregularityDto.setIrregularityTypesDtoList(irregularityTypesConverter.convertToDto(irregularity.getIrregularityTypesList()));

        return irregularityDto;
    }

    public List<IrregularityDto> convertToDto(List<Irregularity> irregularitiesList){
        List<IrregularityDto> irregularitiesDtoList = new ArrayList<>();

        for (Irregularity irregularity : irregularitiesList) {
            irregularitiesDtoList.add(convertToDto(irregularity));
        }

        return irregularitiesDtoList;
    }

    public List<Irregularity> convertFromDto(List<IrregularityDto> irregularityDtoList) {
        List<Irregularity> irregularitiesList = new ArrayList<>();

        for (IrregularityDto irregularityDto : irregularityDtoList) {
            irregularitiesList.add(convertFromDto(irregularityDto));
        }

        return irregularitiesList;

    }
}
