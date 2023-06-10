package is.technologies.Interfaces.Mappers;

import is.technologies.Entities.BrandEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Insert("INSERT INTO brand (brand_id, brand_name, date_of_founding) VALUES(#{id}, #{name}, #{dateOfFounding})")
    void save(BrandEntity entity);

    @Delete("DELETE FROM brand WHERE brand_id = #{id}")
    void deleteById(long id);

    @Delete("DELETE FROM brand WHERE brand_id = #{id}")
    void deleteByEntity(BrandEntity entity);

    @Delete("DELETE FROM brand")
    void deleteAll();

    @Update("UPDATE brand SET brand_name = #{name}, date_of_founding = #{dateOfFounding} WHERE brand_id = #{id}")
    BrandEntity update(BrandEntity entity);

    @Select("SELECT * FROM brand WHERE brand_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "brand_id"),
            @Result(property="name", column = "brand_name"),
            @Result(property = "dateOfFounding", column = "date_of_founding")
    })
    BrandEntity getById(long id);

    @Select("SELECT * FROM brand")
    @Results(value = {
            @Result(property = "id", column = "brand_id"),
            @Result(property="name", column = "brand_name"),
            @Result(property = "dateOfFounding", column = "date_of_founding")
    })
    List<BrandEntity> getAll();
}
