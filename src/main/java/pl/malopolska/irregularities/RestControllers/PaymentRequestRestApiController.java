package pl.malopolska.irregularities.RestControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.irregularities.converters.PaymentRequestConverter;
import pl.malopolska.irregularities.dto.PaymentRequestDto;
import pl.malopolska.irregularities.repository.PaymentRequestRepo;

import java.util.List;

@RestController
@RequestMapping("/rest/payment")
@RequiredArgsConstructor
public class PaymentRequestRestApiController {

    @Autowired
    private final PaymentRequestRepo paymentRequestRepo;

    @Autowired
    private final PaymentRequestConverter paymentRequestConverter;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<PaymentRequestDto> get(@PathVariable("id") Long id){

        return paymentRequestConverter.convertToDto(paymentRequestRepo.findAllByIrregularitiesId(id));

    }
}
