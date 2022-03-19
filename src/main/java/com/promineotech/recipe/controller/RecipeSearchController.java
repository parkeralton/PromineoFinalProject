package com.promineotech.recipe.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.recipe.entity.Recipe;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//@formatter:off
@RequestMapping("/recipes")
@OpenAPIDefinition(info = @Info(title = "Recipe Search Service"), servers = {
   @Server(url = "http://localhost:8080", description = "Local server.")})
public interface RecipeSearchController {
 @Operation(
     summary = "Return Recipes",
     description = "Return recipes based on ingredients, country, and cook status",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "Recipes are returned", 
             content = @Content(mediaType = "application/json", 
             schema = @Schema(implementation = Recipe.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are wrong", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No Recipes found", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "Unplanned error", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(
             name = "ingredient", 
             allowEmptyValue = true, 
             required = false, 
             description = "Ingredient Name"),
         @Parameter(
             name = "country", 
             allowEmptyValue = true, 
             required = false, 
             description = "Country of Origin"),
         @Parameter(
             name = "cooked",
             allowEmptyValue = false,
             required = true,
             description = "Has been cooked?")
     }
 )
 @GetMapping
 @ResponseStatus(code = HttpStatus.OK)
 List<Recipe> fetchRecipe(@RequestParam(required = false) String ingredient, 
                          @RequestParam(required = false) String country,
                          @RequestParam(required = true) Boolean cooked);
 
//@formatter:on
}

