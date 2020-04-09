package pl.malopolska.irregularities.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.dto.ProjectDto;
import pl.malopolska.irregularities.model.Project;
import pl.malopolska.irregularities.services.BeneficiaryService;
import pl.malopolska.irregularities.services.PaymentRequestService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectConverter {

    @Autowired
    private BeneficiaryConverter beneficiaryConverter;

    @Autowired
    private PaymentRequestConverter prc;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private PaymentRequestService paymentRequestService;

    public Project convertFromDto(ProjectDto projectDto){
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setProjectNumber(projectDto.getProjectNumber());
        project.setBeneficiary(beneficiaryService.getBeneficiary(projectDto.getBeneficiaryId()));
        project.setPaymentRequestList(paymentRequestService.getAllPaymentRequestByProjectId(projectDto.getId()));

        return project;    }

    public ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectNumber(project.getProjectNumber());
        projectDto.setBeneficiaryId(project.getBeneficiary().getId());
        //projectDto.setPaymentRequestDtoList(prc.convertToDto(project.getPaymentRequestList()));

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
