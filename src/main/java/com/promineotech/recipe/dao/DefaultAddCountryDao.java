package com.promineotech.recipe.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.recipe.entity.CountryOfOrigin;
@Component
public class DefaultAddCountryDao implements AddCountryDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public CountryOfOrigin addCountry(String countryName) {


    String sql = ""
        + "insert into country_of_origin(country_name) "
        + "values(:countryOfOrigin)";
   
    Map<String, Object> params = new HashMap<>();
    params.put("countryOfOrigin", countryName);

    
    jdbcTemplate.update(sql, params);
    
    
    
    return CountryOfOrigin.builder()
            .countryName(countryName)
            .build();
  }

}
