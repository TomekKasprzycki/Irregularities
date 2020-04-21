package pl.malopolska.irregularities.convertersFromString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.PaymentRequestConverter;
import pl.malopolska.irregularities.dto.PaymentRequestDto;
import pl.malopolska.irregularities.services.PaymentRequestService;

public class ConverterPaymentRequestFromString implements Converter<String, PaymentRequestDto> {

    @Autowired
    private PaymentRequestService paymentRequestService;
    @Autowired
    private PaymentRequestConverter paymentRequestConverter;

//    public ConverterPaymentRequestFromString(PaymentRequestService paymentRequestService,
//                                              PaymentRequestConverter paymentRequestConverter) {
//        this.paymentRequestConverter = paymentRequestConverter;
//        this.paymentRequestService = paymentRequestService;
//    }

    @Override
    public PaymentRequestDto convert(String s) {
        return paymentRequestConverter.convertToDto(paymentRequestService.getById(Long.parseLong(s)));
    }
}
