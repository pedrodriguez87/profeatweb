import data.Meal;
import repository.DataSourceUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcExample {

    public static void main(String[] args) throws SQLException {

        DataSource dataSource = DataSourceUtil.getDataSourceInPath();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from meals");

        List<Meal> meals = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            long price = rs.getLong("price");
            String mainprotein = rs.getString("Protein");
            System.out.println(id + ", " + name + ", " + price);

        }

        rs.close();
        statement.close();
        connection.close();

        System.out.println("Meals: ");
        for (Meal meal : meals) {
            System.out.println(meal.getId() + " " + meal.getName() + " " +
                    meal.getPrice() + " " + meal.getMainprotein());
        }

    }
}