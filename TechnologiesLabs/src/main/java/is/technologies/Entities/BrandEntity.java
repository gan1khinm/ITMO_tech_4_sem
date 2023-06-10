package is.technologies.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Table(name = "brand", schema = "public", catalog = "lab2")
public class BrandEntity {
    @Id
    @Column(name = "brand_id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Basic
    @Column(name = "brand_name", nullable = false, length = -1)
    @Getter
    @Setter
    private String name;

    @Basic
    @Column(name = "date_of_founding", nullable = false)
    @Getter
    @Setter
    private Date dateOfFounding;
}