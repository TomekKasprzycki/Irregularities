package pl.malopolska.irregularities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.malopolska.irregularities.model.Role;
import pl.malopolska.irregularities.repository.RoleRepo;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> getRole(){return roleRepo.findAll();}

    public Role getRoleById(Long id){return roleRepo.findRoleById(id);}
}
