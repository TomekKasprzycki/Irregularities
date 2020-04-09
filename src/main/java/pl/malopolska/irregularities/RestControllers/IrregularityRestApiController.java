package pl.malopolska.irregularities.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import pl.malopolska.irregularities.converters.IrregularityConverter;
import pl.malopolska.irregularities.dto.IrregularityDto;
import pl.malopolska.irregularities.model.Irregularity;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.services.IrregularitiesService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
public class IrregularityRestApiController {

    @Autowired
    private IrregularitiesService irregularitiesService;

    @Autowired
    private IrregularityConverter irregularityConverter;

    @PostMapping(value = "/rest/new_irregularity",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RedirectView saveNewIrregularity(@RequestBody IrregularityDto irregularityDto, HttpSession session){
        Irregularity irregularity = irregularityConverter.convertFromDto(irregularityDto);
        irregularity.setCreated(LocalDateTime.now());
        irregularity.setCreator((User) session.getAttribute("user"));

        irregularitiesService.save(irregularity);
        return new RedirectView("/main/mainPage");
    }

}
