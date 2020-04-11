package pl.malopolska.irregularities.convertersFromString;

import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.PaymentRequestConverter;
import pl.malopolska.irregularities.dto.PaymentRequestDto;
import pl.malopolska.irregularities.services.PaymentRequestService;

public class ConverterPaymentRequestFromString implements Converter<String, PaymentRequestDto> {

    private PaymentRequestService paymentRequestService;
    private PaymentRequestConverter paymentRequestConverter;

    private ConverterPaymentRequestFromString(PaymentRequestService paymentRequestService,
                                              PaymentRequestConverter paymentRequestConverter) {
        this.paymentRequestConverter = paymentRequestConverter;
        this.paymentRequestService = paymentRequestService;
    }

    @Override
    public PaymentRequestDto convert(String s) {
        return paymentRequestConverter.convertToDto(paymentRequestService.getById(Long.parseLong(s)));
    }
}
