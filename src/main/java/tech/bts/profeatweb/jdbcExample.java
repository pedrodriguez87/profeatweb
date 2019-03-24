package tech.bts.profeatweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


public class jdbcExample {

    public static void main(String[] args) throws SQLException {

        /*DataSource dataSource = DataSourceUtil.getDataSourceInPath();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from meals");

        List<Meal> meals = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            long price = rs.getLong("price");
            System.out.println(id + ", " + name + ", " + price);

        }

        rs.close();
        statement.close();
        connection.close();

        System.out.println("Meals: ");
        for (Meal meal : meals) {
            System.out.println(meal.getId() + " " + meal.getName() + " " +
                    meal.getPrice());
        }*/

    }
}