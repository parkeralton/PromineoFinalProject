package com.promineotech.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.recipe.dao.AddIngredientDao;
import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;
@Service
public class DefaultAddIngredientService implements AddIngredientService {

  @Autowired
  private AddIngredientDao addIngredientDao;
  @Override
  @Transactional
  public Ingredients addIngredient(String recipeName, String ingredientName) {
    // TODO Auto-generated method stub
    return addIngredientDao.addIngredient(recipeName, ingredientName);
  }

}
