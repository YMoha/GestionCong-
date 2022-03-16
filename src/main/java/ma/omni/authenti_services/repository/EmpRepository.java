package ma.omni.authenti_services.repository;

import ma.omni.authenti_services.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmpRepository extends JpaRepository<Employer, Long> {
    Employer findByUserName(String userName);

}
