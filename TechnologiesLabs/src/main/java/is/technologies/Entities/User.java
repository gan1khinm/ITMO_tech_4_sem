package is.technologies.Entities;

import is.technologies.SpringSecurity.Entities.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Basic
    @Column(name = "username", nullable = false, length = -1)
    @Getter
    @Setter
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    @Getter
    @Setter
    private String password;

    @Basic
    @Column(name = "role", nullable = false)
    @Getter
    @Setter
    private Role role;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_model", nullable = false)
    @Getter
    @Setter
    private ModelEntity model;*/
}