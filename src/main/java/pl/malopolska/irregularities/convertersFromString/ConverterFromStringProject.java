package pl.malopolska.irregularities.convertersFromString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.malopolska.irregularities.converters.ProjectConverter;
import pl.malopolska.irregularities.dto.ProjectDto;
import pl.malopolska.irregularities.services.ProjectService;

public class ConverterFromStringProject implements Converter<String, ProjectDto> {

    @Autowired
    private ProjectConverter projectConverter;
    @Autowired
    private ProjectService projectService;

//    public ConverterFromStringProject(ProjectConverter projectConverter,
//                                      ProjectService projectService){
//        this.projectConverter = projectConverter;
//        this.projectService = projectService;
//    }

    @Override
    public ProjectDto convert(String s) {
        return projectConverter.convertToDto(projectService.getProjectById(Long.parseLong(s)));
    }
}
