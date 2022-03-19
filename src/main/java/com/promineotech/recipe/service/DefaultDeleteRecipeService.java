package com.promineotech.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.recipe.dao.DeleteRecipeDao;
import com.promineotech.recipe.entity.Recipe;

@Service
public class DefaultDeleteRecipeService implements DeleteRecipeService {

  @Autowired
  private DeleteRecipeDao deleteRecipeDao;
  
  @Override
  public Recipe deleteRecipe(String RecipeName) {
    // TODO Auto-generated method stub
    return deleteRecipeDao.deleteRecipe(RecipeName);
  }

}
