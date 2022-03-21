package ma.omni.authenti_services.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Roles {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoles    ;
    private String roleName;

}
