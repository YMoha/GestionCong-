package ma.omni.authenti_services.repository;

import ma.omni.authenti_services.entities.Employer;
import ma.omni.authenti_services.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByRoleName(String roleName);
}
