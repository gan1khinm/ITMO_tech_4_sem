package is.technologies.JDBC;

import is.technologies.Entities.BrandEntity;
import is.technologies.Interfaces.BrandRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryJDBC implements BrandRepository {
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
    public BrandRepositoryJDBC(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public BrandEntity save(BrandEntity entity) {
        try{
            String sql = "INSERT INTO brand (brand_id, brand_name, date_of_founding) Values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setDate(3, entity.getDateOfFounding());

            preparedStatement.execute();
            return entity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void deleteById(long id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM brand WHERE brand_id = " + id;
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteByEntity(BrandEntity entity) {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM brand WHERE brand_id = " + entity.getId();
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM brand";
            statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public BrandEntity update(BrandEntity entity){
        try {
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE brand SET date_of_founding = ?, brand_name = ? WHERE brand_id = ?");
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setDate(3, entity.getDateOfFounding());
            preparedStatement.execute();

            return entity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public BrandEntity getById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM brand WHERE brand_id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            BrandEntity entity = new BrandEntity();
            entity.setId(resultSet.getLong("brand_id"));
            entity.setName(resultSet.getString("brand_name"));
            entity.setDateOfFounding(resultSet.getDate("date_of_founding"));

            return entity;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<BrandEntity> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM brand");
            ArrayList<BrandEntity> CarBrandEntities = new ArrayList<>();

            while(resultSet.next())
            {
                BrandEntity entity = new BrandEntity();
                entity.setId(resultSet.getLong("brand_id"));
                entity.setName(resultSet.getString("brand_name"));
                entity.setDateOfFounding(resultSet.getDate("date_of_founding"));

                CarBrandEntities.add(entity);
            }

            return CarBrandEntities;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
