package ma.omni.authenti_services.sec.service;

import ma.omni.authenti_services.sec.entities.Employer;
import ma.omni.authenti_services.sec.entities.Roles;
import ma.omni.authenti_services.sec.repository.EmpRepository;
import ma.omni.authenti_services.sec.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ServiceAuthImpl implements ServiceAuth {

    private EmpRepository empRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public ServiceAuthImpl(EmpRepository empRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.empRepository = empRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Employer addNewEmp(Employer employer) {
        String pw= employer.getPassword();
        employer.setPassword(passwordEncoder.encode(pw));
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
        return empRepository.findByUserName(userName);
    }

    @Override
    public List<Employer> listEmp() {
        return empRepository.findAll();
    }
}
