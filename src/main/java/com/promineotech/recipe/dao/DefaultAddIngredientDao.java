package com.promineotech.recipe.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.recipe.entity.CountryOfOrigin;
import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;
@Component
public class DefaultAddIngredientDao implements AddIngredientDao {
@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Ingredients addIngredient(String recipeName, String ingredientName) {
    String sql = ""
        + "insert into recipe_ingredient(recipe_fk, ingredient_fk) "
        + "values ((select recipe_pk from recipe where recipe_name  = :recipeName), "
        + "(select ingredient_pk from ingredients where ingredient_name = :ingredientName))";
   
    Map<String, Object> params = new HashMap<>();
    params.put("recipeName", recipeName);
    params.put("ingredientName", ingredientName);
    
    jdbcTemplate.update(sql, params);
    
    
    
    return Ingredients.builder()
        .ingredient(ingredientName)
        .build();
  }

}
