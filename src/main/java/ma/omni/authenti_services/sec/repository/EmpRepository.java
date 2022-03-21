package ma.omni.authenti_services.sec.repository;

import ma.omni.authenti_services.sec.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmpRepository extends JpaRepository<Employer, Long> {
    Employer findByUserName(String userName);

}
