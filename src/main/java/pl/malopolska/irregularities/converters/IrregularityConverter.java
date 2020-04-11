package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.IrregularityDto;
import pl.malopolska.irregularities.model.Irregularity;

import java.util.ArrayList;
import java.util.List;

@Service
public class IrregularityConverter {

    private PaymentRequestConverter paymentRequestConverter;
    private DocumentBaseIrregularityConverter dbic;
    private IrregularityTypesConverter irregularityTypesConverter;
    private UserConverter userConverter;

    private IrregularityConverter(
             PaymentRequestConverter paymentRequestConverter,
             DocumentBaseIrregularityConverter dbic,
             IrregularityTypesConverter irregularityTypesConverter,
             UserConverter userConverter) {
        this.paymentRequestConverter = paymentRequestConverter;
        this.dbic = dbic;
        this.irregularityTypesConverter = irregularityTypesConverter;
        this.userConverter = userConverter;
    }



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
        irregularity.setCreator(userConverter.convertFromDto(irregularityDto.getUserDto()));
        irregularity.setTotalExpenses(irregularityDto.getTotalExpenses());
        irregularity.setQualifiedExpenses(irregularityDto.getQualifiedExpenses());
        irregularity.setDetectedBeforeSendToEC(irregularityDto.isDetectedBeforeSendToEC());
        irregularity.setDocumentBaseIrregularity(dbic.convertFromDto(irregularityDto.getDocumentBaseIrregularityDto()));
        irregularity.setDateOfIrregularity(irregularityDto.getDateOfIrregularity());
        irregularity.setDescription(irregularityDto.getDescription());
        irregularity.setCaseID(irregularityDto.getCaseID());
        irregularity.setNotes(irregularityDto.getNotes());
        irregularity.setVisibleToCA(irregularityDto.isVisibleToCA());
        irregularity.setPaymentRequestList(paymentRequestConverter.convertFromDto(irregularityDto.getPaymentRequestDto()));
        irregularity.setCreated(irregularityDto.getCreated());
        irregularity.setIrregularityTypesList(irregularityTypesConverter.convertFromDto(irregularityDto.getIrregularityTypesDto()));
        irregularity.setDocumentBaseIrregularity(dbic.convertFromDto(irregularityDto.getDocumentBaseIrregularityDto()));
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
        irregularityDto.setUserDto(userConverter.convertToDto(irregularity.getCreator()));
        irregularityDto.setTotalExpenses(irregularity.getTotalExpenses());
        irregularityDto.setQualifiedExpenses(irregularity.getQualifiedExpenses());
        irregularityDto.setDetectedBeforeSendToEC(irregularity.isDetectedBeforeSendToEC());
        irregularityDto.setDocumentBaseIrregularityDto(dbic.convertToDto(irregularity.getDocumentBaseIrregularity()));
        irregularityDto.setDateOfIrregularity(irregularity.getDateOfIrregularity());
        irregularityDto.setDescription(irregularity.getDescription());
        irregularityDto.setCaseID(irregularity.getCaseID());
        irregularityDto.setNotes(irregularity.getNotes());
        irregularityDto.setVisibleToCA(irregularity.isVisibleToCA());
        irregularityDto.setPaymentRequestDto(paymentRequestConverter.convertToDto(irregularity.getPaymentRequestList()));
        irregularityDto.setCreated(irregularity.getCreated());
        irregularityDto.setIrregularityTypesDto(irregularityTypesConverter.convertToDto(irregularity.getIrregularityTypesList()));

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
