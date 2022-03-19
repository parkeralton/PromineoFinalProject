package com.promineotech.recipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;

@Component
public class DefaultIngredientSeasonDao implements IngredientSeasonDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Ingredients> fetchIngredients(String date) {
    String defaultYear = "2000-";
    String dateString = defaultYear.concat(date);
    
String sql = "select * from ingredients where season_start <= :date and season_end >= :date";

Map<String, Object> params = new HashMap<>();
params.put("date", dateString);



return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Ingredients mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return Ingredients.builder()
            .ingredient(rs.getString("ingredient_name"))
            .seasonStart(rs.getString("season_start"))
            .seasonEnd(rs.getString("season_end"))
            .build();
      }});
  }

}
