package ma.omni.authenti_services.sec.repository;

import ma.omni.authenti_services.sec.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByRoleName(String roleName);
}
