package pl.malopolska.irregularities.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.irregularities.converters.IrregularityTypesConverter;
import pl.malopolska.irregularities.dto.IrregularityTypesDto;
import pl.malopolska.irregularities.services.IrregularityTypesService;

import java.util.List;

@RestController
@RequestMapping("/rest/irregularityTypes")
public class IrregularityTypesRequestRestApiController {

    @Autowired
    private IrregularityTypesService its;

    @Autowired
    private IrregularityTypesConverter itc;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<IrregularityTypesDto> get(@PathVariable("id") Long id){
        return itc.convertToDto(its.getAllByIrregularityId(id));
    }


}
