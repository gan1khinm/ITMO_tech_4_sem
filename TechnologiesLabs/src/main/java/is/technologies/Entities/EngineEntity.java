package is.technologies.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "engine", schema = "public", catalog = "lab2")
public class EngineEntity {
    @Id
    @Column(name = "engine_id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "engine_name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "engine_volume", nullable = false)
    @Getter
    @Setter
    private long volume;

    @Column(name = "cylinders_amount", nullable = false)
    @Getter
    @Setter
    private long cylindersAmount;

    @Column(name = "engine_height", nullable = false)
    @Getter
    @Setter
    private long height;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_model", nullable = false)
    @Getter
    @Setter
    private ModelEntity model;
}
