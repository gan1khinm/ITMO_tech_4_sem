package is.technologies.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "model", schema = "public", catalog = "lab2")
public class ModelEntity {
    @Id
    @Column(name = "model_id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "model_name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "model_length", nullable = false)
    @Getter
    @Setter
    private long length;

    @Column(name = "model_width", nullable = false)
    @Getter
    @Setter
    private long width;

    @Column(name = "model_height", nullable = false)
    @Getter
    @Setter
    private long height;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand", nullable = false)
    @Getter
    @Setter
    private BrandEntity brand;

    @Column(name = "body_type", nullable = false)
    @Getter
    @Setter
    private String bodyType;
}
