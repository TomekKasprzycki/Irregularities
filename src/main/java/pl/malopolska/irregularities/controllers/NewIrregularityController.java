package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import pl.malopolska.irregularities.converters.*;
import pl.malopolska.irregularities.dto.*;
import pl.malopolska.irregularities.model.*;
import pl.malopolska.irregularities.services.DocumentBaseIrregularityService;
import pl.malopolska.irregularities.services.IrregularitiesService;
import pl.malopolska.irregularities.services.IrregularityTypesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class NewIrregularityController {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IrregularityTypesService its;

    @Autowired
    private IrregularityTypesConverter itc;

    @Autowired
    private DocumentBaseIrregularityService dbis;

    @Autowired
    private DocumentBaseIrregularityConverter dbic;

    @Autowired
    private IrregularityConverter irregularityConverter;

    @Autowired
    private IrregularitiesService irregularitiesService;

    @Autowired
    private PaymentRequestConverter paymentRequestConverter;

    @GetMapping("/main/new_irregularity")
    public String newIrregularityPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDto userDto = userConverter.convertToDto((User) session.getAttribute("user"));
        model.addAttribute("userDto",userDto);
        model.addAttribute("beneficiaryDto", new BeneficiaryDto());
        model.addAttribute("projectDto",new ProjectDto());
        List<IrregularityTypesDto> irregularityTypesDtoList = itc.convertToDto(its.irregularityTypesList());
        model.addAttribute("irregularityTypesDtoList", irregularityTypesDtoList);
        List<DocumentBaseIrregularityDto> documentBaseIrregularityDtoList = dbic.convertToDto(dbis.getAll());
        model.addAttribute("documentBaseIrregularityDtoList",documentBaseIrregularityDtoList);
        model.addAttribute("irregularityDto", new IrregularityDto());
            return "new_irregularity";
    }

    @PostMapping("/main/new_irregularity")
    public RedirectView newIrregularityInsert(@RequestParam IrregularityDto irregularityDto,
                                              HttpSession session){
        User user = (User) session.getAttribute("user");
        Irregularity irregularity = irregularityConverter.convertFromDto(irregularityDto);
        irregularity.setCreator(user);
        irregularity.setCreated(LocalDateTime.now());
        irregularitiesService.save(irregularity);

        return new RedirectView("/main/new_irregularity");
    }



}
