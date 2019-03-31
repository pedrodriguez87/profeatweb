package tech.bts.profeatweb.util.database;

import com.github.jknack.handlebars.internal.lang3.ObjectUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SqlBuilderTest {

    @Test
    public void selectFromTable(){
        // 1. Prepare objects
        SqlBuilder sqlBuilder = new SqlBuilder();

        // 2. Call some methods
        sqlBuilder.from("meals");
        String sql = sqlBuilder.build();

        // 3. Check results
        assertThat(sql, is("select * from meals"));
    }

    @Test
    public void selectFromTableSimplified() {
        String sql = new SqlBuilder().from("meals").build();
        assertThat(sql, is("select * from meals"));
    }

    @Test
    public void whereCondition() {
        String sql = new SqlBuilder()
                .from("meals")
                .where("name = 'Paella'")
                .build();
        assertThat(sql, is("select * from meals where name = 'Paella'"));
    }

    @Test
    public void whereMultipleConditions() {
        String sql = new SqlBuilder()
                .from("meals")
                .where("name = 'Paella'")
                .where("price <= 12")
                .build();
        assertThat(sql, is("select * from meals where name = 'Paella' and price <= 12"));
    }

    @Test
    public void whereEasierMultipleConditions() {
        String sql = new SqlBuilder()
                .from("meals")
                .where("name", "=", "Paella")
                .where("price", "<=", 12)
                .build();
        assertThat(sql, is("select * from meals where name = 'Paella' and price <= 12"));
    }

    @Test
    public void whereWithNulls() {
        String sql = new SqlBuilder()
                .from("meals")
                .where("name", "=", null)
                .where("price", "<=", null)
                .build();
        assertThat(sql, is("select * from meals"));
    }

}