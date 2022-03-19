package com.promineotech.recipe.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.recipe.entity.Recipe;

@Component
public class DefaultDeleteRecipeDao implements DeleteRecipeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public Recipe deleteRecipe(String recipeName) {
    String sql = ""
        + "delete from recipe "
        + "where recipe_name = :recipeName";
    
    Map<String, Object> params = new HashMap<>();
    params.put("recipeName", recipeName);
    
    jdbcTemplate.update(sql, params);
    return Recipe.builder()
        .recipeName(recipeName)
        .build();
  }

}
