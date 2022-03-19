package com.promineotech.recipe.controller;

import java.time.MonthDay;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.recipe.entity.Ingredients;
import com.promineotech.recipe.entity.Recipe;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


  @RequestMapping("/Ingredients")
  @OpenAPIDefinition(info = @Info(title = "In Season Ingredient"), servers = {
     @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface IngredientSeasonController {
   @Operation(
       summary = "Return Ingredients",
       description = "Return ingredients based on whether they are in season or not.",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "Ingredients are returned", 
               content = @Content(mediaType = "application/json", 
               schema = @Schema(implementation = Recipe.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The request parameters are wrong", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "No Ingredients found", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "Unplanned error", 
               content = @Content(mediaType = "application/json"))
       },
       parameters = {
           @Parameter(
               name = "date", 
               allowEmptyValue = false, 
               required = true, 
               description = "date in MM-DD format"),
       }
       
   
)
 
  




  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Ingredients> fetchIngredients(@RequestParam(required = true) String date);
}

//@formatter:on