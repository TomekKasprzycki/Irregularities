package pl.malopolska.irregularities.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.malopolska.irregularities.converters.ProjectConverter;
import pl.malopolska.irregularities.dto.ProjectDto;
import pl.malopolska.irregularities.services.ProjectService;

import java.util.List;


@RestController
@RequestMapping("/rest/project")
public class ProjectRequestRestApiController {


        @Autowired
        private ProjectService projectService;

        @Autowired
        private ProjectConverter projectConverter;

        @RequestMapping(method = RequestMethod.GET, value = "/{id}")
        public List<ProjectDto> get(@PathVariable("id") Long id){
            List<ProjectDto> list = projectConverter.convertToDto(projectService.getAllProjectsByBeneficiaryId(id));
            return list;
        }


}
