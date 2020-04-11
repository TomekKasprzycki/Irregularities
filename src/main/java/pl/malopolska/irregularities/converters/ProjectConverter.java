package pl.malopolska.irregularities.converters;

import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.ProjectDto;
import pl.malopolska.irregularities.model.Project;
import pl.malopolska.irregularities.services.BeneficiaryService;
import pl.malopolska.irregularities.services.PaymentRequestService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectConverter {

    private PaymentRequestConverter prc;
    private BeneficiaryConverter beneficiaryConverter;

    private ProjectConverter(BeneficiaryConverter beneficiaryConverter,
                             PaymentRequestConverter prc){
        this.beneficiaryConverter = beneficiaryConverter;
        this.prc = prc;
    }

    public Project convertFromDto(ProjectDto projectDto){
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setProjectNumber(projectDto.getProjectNumber());
        project.setBeneficiary(beneficiaryConverter.convertFromDto(projectDto.getBeneficiaryDto()));
        project.setPaymentRequestList(prc.convertFromDto(projectDto.getPaymentRequestDto()));

        return project;    }

    public ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectNumber(project.getProjectNumber());
        projectDto.setBeneficiaryDto(beneficiaryConverter.convertToDto(project.getBeneficiary()));
        projectDto.setPaymentRequestDto(prc.convertToDto(project.getPaymentRequestList()));

        return projectDto;
    }

    public List<Project> convertFromDto(List<ProjectDto> projectDtoList){
        List<Project> projectList = new ArrayList<>();
        for (ProjectDto projectDto:projectDtoList) {
            projectList.add(convertFromDto(projectDto));
        }
        return projectList;
    }

    public List<ProjectDto> convertToDto(List<Project> projectList){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project:projectList) {
            projectDtoList.add(convertToDto(project));
        }
        return projectDtoList;
    }

}
