package ma.omni.authenti_services.service;

import ma.omni.authenti_services.entities.Employer;
import ma.omni.authenti_services.entities.Roles;
import ma.omni.authenti_services.repository.EmpRepository;
import ma.omni.authenti_services.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ServiceAuthImpl implements ServiceAuth {

    private EmpRepository empRepository;

    private RoleRepository roleRepository;

    public ServiceAuthImpl(EmpRepository empRepository, RoleRepository roleRepository) {
        this.empRepository = empRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Employer addNewEmp(Employer employer) {
        return empRepository.save(employer);
    }

    @Override
    public Roles addNewRoles(Roles roles) {
        return roleRepository.save(roles);
    }

    @Override
    public void addRoletoEmp(String userName, String roleName) {
        Employer employer = empRepository.findByUserName(userName);
        Roles roles = roleRepository.findByRoleName(roleName);
        employer.getRoles().add(roles);

    }

    @Override
    public Employer findEmpByUserName(String userName) {
        return null;
    }

    @Override
    public List<Employer> listEmp() {
        return null;
    }
}
