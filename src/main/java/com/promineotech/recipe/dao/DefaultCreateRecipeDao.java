package com.promineotech.recipe.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.recipe.entity.Recipe;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class DefaultCreateRecipeDao implements CreateRecipeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public Recipe saveRecipe(String recipeName, String countryOfOrigin, boolean cooked) {
    log.info("dao recipe={}, country={}, cooked = {}", recipeName, countryOfOrigin, cooked);
    String sql = ""
        +"insert into recipe(recipe_name, has_been_cooked, country_fk) "
        + "select :recipeName, "
        + ":cooked, "
        + "country_pk from country_of_origin where country_name = :countryOfOrigin";
   
    Map<String, Object> params = new HashMap<>();
    params.put("recipeName", recipeName);
    params.put("countryOfOrigin", countryOfOrigin);
    params.put("cooked", cooked);
    
    jdbcTemplate.update(sql, params);
    
    return Recipe.builder()
        .recipeName(recipeName)
        .hasBeenCooked(cooked)
        .build();
  }

}
