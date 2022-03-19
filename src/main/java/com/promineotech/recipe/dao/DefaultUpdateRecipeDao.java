package com.promineotech.recipe.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.recipe.entity.Recipe;
@Component
public class DefaultUpdateRecipeDao implements UpdateRecipeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Recipe updateRecipe(String recipeName, boolean cooked) {
    
    String sql = ""
        + "UPDATE recipe "
        + "SET has_been_cooked = :cooked "
        + "WHERE recipe_name = :recipeName";
    
    Map<String, Object> params = new HashMap<>();
    params.put("recipeName", recipeName);
    params.put("cooked", cooked);
    
    jdbcTemplate.update(sql, params);
    
    return Recipe.builder()
        .recipeName(recipeName)
        .hasBeenCooked(cooked)
        .build();
    
  }

}
