package tech.bts.profeatweb.repository;
import tech.bts.profeatweb.data.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.bts.profeatweb.util.database.SqlBuilder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class MealRepositoryJdbc implements MealRepository{

    //private Map<Long, Meal> mealMap;
    //private long nextId;
    private JdbcTemplate jdbcTemplate;


    public MealRepositoryJdbc() {
        //mealMap = new HashMap<>();
        //nextId = 0;
        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Meal meal) {
        //add meal to map
        //meal.setId(nextId);
        //mealMap.put(meal.getId(), meal);
        //nextId++;

        //add meal to database
        jdbcTemplate.update("insert into meals (name, price) values ('" + meal.getName() + "', '" + meal.getPrice() + "')");

        //BE AWARE THAT THIS WAY MEALS MAY HAVE DIFFERENT ID IN THE MAP AND IN THE DATABASE!!!
    }

    public Meal getById(Long id) {
        //from the map -> return mealMap.get(id);

        //from the database
        String sql = new SqlBuilder()
                .from("meals")
                .where("id", "=", id)
                .build();
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> getMeal(resultSet));
    }

    private Meal getMeal(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = Double.parseDouble(resultSet.getString("price"));

        Meal meal = new Meal();
        meal.setName(name);
        meal.setPrice(price);
        meal.setId(id);

        return meal;
    }

    public Collection<Meal> getAll() {
        //from the map -> return mealMap.values();

        //from the database
        String sql = new SqlBuilder().from("meals").build();
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> getMeal(resultSet));
    }
}
