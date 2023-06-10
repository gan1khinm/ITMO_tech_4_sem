package is.technologies.Interfaces.Mappers;

import is.technologies.Entities.BrandEntity;
import is.technologies.Entities.ModelEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ModelMapper {
    @Insert("INSERT INTO brand (model_id, model_name, model_length, model_width, brand, body_type) VALUES(#{id}, #{name}, #{length}, #{width}, #{brand.id}, #{bodyType})")
    ModelEntity save(ModelEntity entity);

    @Delete("DELETE FROM brand WHERE model_id = #{id}")
    void deleteById(long id);

    @Delete("DELETE FROM brand WHERE model_id = #{id}")
    void deleteByEntity(ModelEntity entity);

    @Delete("DELETE FROM model")
    void deleteAll();

    @Update("UPDATE model SET model_name = #{name}, model_length = #{length}, model_width = #{width}, brand = #{brand.id}, body_type = #{bodyType} WHERE model_id = #{id}")
    ModelEntity update(ModelEntity entity);

    @Select("SELECT * FROM brand WHERE model_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "model_id"),
            @Result(property="name", column = "model_name"),
            @Result(property = "length", column = "model_length"),
            @Result(property = "width", column = "model_width"),
            @Result(property = "bodyType", column = "body_type"),
            @Result(property = "brand", column = "model_brand",
                    javaType = BrandEntity.class,
                    one = @One(select = "Interfaces.Mappers.BrandMapper.getById"))
    })
    ModelEntity getById(long id);

    @Select("SELECT * FROM brand")
    @Results(value = {
            @Result(property = "id", column = "model_id"),
            @Result(property="name", column = "model_name"),
            @Result(property = "length", column = "model_length"),
            @Result(property = "width", column = "model_width"),
            @Result(property = "bodyType", column = "body_type"),
            @Result(property = "brand", column = "model_brand",
                    javaType = BrandEntity.class,
                    one = @One(select = "Interfaces.Mappers.BrandMapper.getById"))
    })
    List<ModelEntity> getAll();
}
