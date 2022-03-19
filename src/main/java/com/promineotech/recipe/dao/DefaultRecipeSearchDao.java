package com.promineotech.recipe.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.recipe.entity.Recipe;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultRecipeSearchDao implements RecipeSearchDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Recipe> fetchRecipe(String ingredient, String country, Boolean cooked) {
  
    String sql = ""
    
    + "select distinct r.recipe_name from recipe r "
    + "inner join country_of_origin coo on coo.country_pk = r.country_fk "
    + "inner join recipe_ingredient ri on ri.recipe_fk = r.recipe_pk  "
    + "inner join ingredients i on i.ingredient_pk = ri.ingredient_fk "
    + "where ";

    
    if (! ingredient.isEmpty()) {
      sql = sql.concat("i.ingredient_name = :ingredient and ");
    }
    
    if (! country.isEmpty()) {
      sql = sql.concat("coo.country_name = :country and ");
    }
    
      sql = sql.concat("has_been_cooked = :cooked");
      
 
    
    Map<String, Object> params = new HashMap<>();
    params.put("ingredient", ingredient);
    params.put("country", country);
    params.put("cooked", cooked);
    

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
    
          @Override
          public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            return Recipe.builder()
                .recipeName(rs.getString("recipe_name"))
                .build();
          }});

}
}
