package ma.omni.authenti_services.sec.service;

import ma.omni.authenti_services.sec.entities.Employer;
import ma.omni.authenti_services.sec.entities.Roles;

import java.util.List;

public interface ServiceAuth {
    Employer addNewEmp(Employer employer);
    Roles addNewRoles(Roles roles);
    void addRoletoEmp(String userName ,String roleName);
    Employer findEmpByUserName(String userName);
    List <Employer> listEmp();
}
