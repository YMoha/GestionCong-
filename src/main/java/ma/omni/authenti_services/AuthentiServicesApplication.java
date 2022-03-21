package ma.omni.authenti_services;


import ma.omni.authenti_services.sec.entities.Employer;
import ma.omni.authenti_services.sec.entities.Roles;
import ma.omni.authenti_services.sec.service.ServiceAuth;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthentiServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthentiServicesApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start (ServiceAuth serviceAuth) {
        return args -> {
            //******Ajouté des roles*****/
            serviceAuth.addNewRoles(new Roles(null,"Administrateur"));
            serviceAuth.addNewRoles(new Roles(null,"Directeur_BU"));
            serviceAuth.addNewRoles(new Roles(null,"Chef_Projet"));
            serviceAuth.addNewRoles(new Roles(null,"Responsable_Pool"));
            serviceAuth.addNewRoles(new Roles(null,"Employer"));
            //******Ajouté des Employers*****/
            serviceAuth.addNewEmp(new Employer(null,"Youssef","12345",new ArrayList<>()));
            serviceAuth.addNewEmp(new Employer(null,"Admin","23451",new ArrayList<>()));
            serviceAuth.addNewEmp(new Employer(null,"Yassmine","34512",new ArrayList<>()));
            serviceAuth.addNewEmp(new Employer(null,"Mahmoud","45123",new ArrayList<>()));
            serviceAuth.addNewEmp(new Employer(null,"Amal","12345",new ArrayList<>()));
            //******Affecter les roles au employers*****/
            serviceAuth.addRoletoEmp("Youssef","Employer");
            serviceAuth.addRoletoEmp("Admin","Employer");
            serviceAuth.addRoletoEmp("Admin","Administrateur");
            serviceAuth.addRoletoEmp("Yassmine","Employer");
            serviceAuth.addRoletoEmp("Yassmine","Responsable_Pool");
            serviceAuth.addRoletoEmp("Mahmoud","Employer");
            serviceAuth.addRoletoEmp("Mahmoud","Chef_Projet");
            serviceAuth.addRoletoEmp("Amal","Employer");
            serviceAuth.addRoletoEmp("Amal","Directeur_BU");

        };
    };

}
