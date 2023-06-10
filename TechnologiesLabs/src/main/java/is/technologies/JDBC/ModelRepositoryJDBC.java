package is.technologies.JDBC;

import is.technologies.Entities.BrandEntity;
import is.technologies.Entities.ModelEntity;
import is.technologies.Interfaces.ModelRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelRepositoryJDBC implements ModelRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/lab2";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "1234";

    static{
        try{
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    public Connection connection;
    public ModelRepositoryJDBC(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ModelEntity save(ModelEntity entity) {
        try {
            String sql = "INSERT INTO brand (model_id, model_name, model_length, model_width, brand, body_type) Values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setLong(3, entity.getLength());
            preparedStatement.setLong(4, entity.getWidth());
            preparedStatement.setLong(5, entity.getBrand().getId());
            preparedStatement.setString(6, entity.getBodyType());

            preparedStatement.execute();
            return entity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void deleteById(long id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM brand WHERE model_id = " + id;
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteByEntity(ModelEntity entity) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM model WHERE model_id = " + entity.getId();
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM model";
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ModelEntity update(ModelEntity entity){
        try {
            Statement statement = connection.createStatement();

            String sql = "UPDATE brand SET body_type ?, brand = ?, model_width = ?, model_length = ?, model_name = ? WHERE model_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setLong(3, entity.getLength());
            preparedStatement.setLong(4, entity.getWidth());
            preparedStatement.setLong(5, entity.getBrand().getId());
            preparedStatement.setString(6, entity.getBodyType());

            preparedStatement.execute();

            return entity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ModelEntity getById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM model WHERE model_id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            ModelEntity modelEntity = new ModelEntity();

            modelEntity.setId(resultSet.getLong("model_id"));
            modelEntity.setName(resultSet.getString("model_name"));
            modelEntity.setLength(resultSet.getLong("model_length"));
            modelEntity.setWidth(resultSet.getLong("model_width"));
            modelEntity.setBodyType(resultSet.getString("body_type"));

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM brand WHERE brand_id = ?");
            preparedStatement2.setLong(1, resultSet.getLong("brand"));

            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();

            BrandEntity brandEntity = new BrandEntity();

            brandEntity.setId(resultSet2.getLong("brand_id"));
            brandEntity.setName(resultSet2.getString("brand_name"));
            brandEntity.setDateOfFounding(resultSet2.getDate("date_of_founding"));

            modelEntity.setBrand(brandEntity);

            return modelEntity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<ModelEntity> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM model");
            ArrayList<ModelEntity> ModelEntities = new ArrayList<>();

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM brand WHERE brand_id = ?");

            while(resultSet.next())
            {
                ModelEntity modelEntity = new ModelEntity();
                modelEntity.setId(resultSet.getLong("model_id"));
                modelEntity.setName(resultSet.getString("model_name"));
                modelEntity.setLength(resultSet.getLong("model_length"));
                modelEntity.setWidth(resultSet.getLong("model_width"));
                modelEntity.setBodyType(resultSet.getString("body_type"));

                preparedStatement2.setLong(1, resultSet.getLong("brand"));

                ResultSet resultSet2 = preparedStatement2.executeQuery();
                resultSet2.next();

                BrandEntity brandEntity = new BrandEntity();

                brandEntity.setId(resultSet2.getLong("brand_id"));
                brandEntity.setName(resultSet2.getString("brand_name"));
                brandEntity.setDateOfFounding(resultSet2.getDate("date_of_founding"));

                modelEntity.setBrand(brandEntity);

                ModelEntities.add(modelEntity);
            }

            return ModelEntities;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
