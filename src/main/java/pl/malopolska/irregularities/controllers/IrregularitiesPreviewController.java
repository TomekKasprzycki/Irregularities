package pl.malopolska.irregularities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.malopolska.irregularities.converters.*;
import pl.malopolska.irregularities.dto.*;
import pl.malopolska.irregularities.model.User;
import pl.malopolska.irregularities.services.*;

import java.util.List;

@Controller
public class IrregularitiesPreviewController {

    @Autowired
    private IrregularitiesService irregularitiesService;

    @Autowired
    private IrregularityConverter irregularityConverter;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private BeneficiaryConverter beneficiaryConverter;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectConverter projectConverter;

    @Autowired
    private PaymentRequestConverter paymentRequestConverter;

    @Autowired
    private PaymentRequestService paymentRequestService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/main/irregularity_preview/{x}/{nip}")
    public String showAllIrregularities(Model model,@PathVariable("x") Integer x,
                                        @PathVariable("nip") String nip){
        if (nip.equals("0")) {
            List<IrregularityDto> irregularitiesDtoList = irregularityConverter.convertToDto(
                    irregularitiesService.getAllToShow());
            Integer y = irregularitiesDtoList.size();
            if(irregularitiesDtoList.size()<x){x=irregularitiesDtoList.size();}
            if(x==0){x=1;}
            IrregularityDto irregularityDto = irregularitiesDtoList.get(x-1);
            final Long id = irregularityDto.getId();
            BeneficiaryDto beneficiaryDto = beneficiaryConverter.convertToDto(beneficiaryService.getBeneficiaryByIrregularityId(id));
            ProjectDto projectDto = projectConverter.convertToDto(projectService.getProjectByIrregularityId(id));
            List<PaymentRequestDto> paymentRequestDtoList =
                    paymentRequestConverter.convertToDto(paymentRequestService.getAllByIrregularityId(id));
            User user = userService.getUserById(irregularityDto.getCreatorId());
            UserDto userDto = userConverter.convertToDto(user);
            List<IrregularityTypesDto> irregularityTypesListDto = itc.convertToDto(its.getAllByIrregularityId(id));
            DocumentBaseIrregularityDto documentBaseIrregularityDto = dbic.convertToDto(dbis.getById(id));
            model.addAttribute("y",y);
            model.addAttribute("documentBaseIrregularityDto",documentBaseIrregularityDto);
            model.addAttribute("irregularityTypesListDto", irregularityTypesListDto);
            model.addAttribute("userDto",userDto);
            model.addAttribute("irregularityDto", irregularityDto);
            model.addAttribute("beneficiaryDto", beneficiaryDto);
            model.addAttribute("projectDto",projectDto);
            model.addAttribute("paymentRequestDtoList",paymentRequestDtoList);
            model.addAttribute("x",x);
        } else {
            List<IrregularityDto> irregularitiesDtoList = irregularityConverter.convertToDto(
                    irregularitiesService.getAllIrregularitiesWithDetailsByBeneficiaryNIP(nip));
            IrregularityDto irregularityDto = irregularitiesDtoList.get(x);
            model.addAttribute("irregularity", irregularityDto);
        }
        return "irregularities_preview";
    }

}
