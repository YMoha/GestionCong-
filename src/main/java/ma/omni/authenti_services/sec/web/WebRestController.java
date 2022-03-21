package ma.omni.authenti_services.sec.web;



import ma.omni.authenti_services.sec.dto.RoleEmpl;
import ma.omni.authenti_services.sec.entities.Employer;
import ma.omni.authenti_services.sec.entities.Roles;
import ma.omni.authenti_services.sec.service.ServiceAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebRestController {
    private ServiceAuth serviceAuth;

    public WebRestController(ServiceAuth serviceAuth) {
        this.serviceAuth = serviceAuth;
    }
    @GetMapping(path = "/Employers")
    public List<Employer> employers(){

        return serviceAuth.listEmp();
    }
    @PostMapping(path = "/Employers")
    public  Employer addEmployer(@RequestBody Employer employer){
        return serviceAuth.addNewEmp(employer);
    }
    @PostMapping(path = "/Roles")
    public Roles addRoles(@RequestBody Roles roles) {
        return serviceAuth.addNewRoles(roles);
    }
    @PostMapping(path = "/AddRoltoEmpl")
    public void AddRoletoEmployer(@RequestBody RoleEmpl roleEmpl){
        serviceAuth.addRoletoEmp(roleEmpl.getUsername(),roleEmpl.getRoleName());

    }

}
