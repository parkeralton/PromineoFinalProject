package com.promineotech.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@Validated
@RequestMapping("/updaterecipe")
@OpenAPIDefinition(info = @Info(title = "Update Recipe"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UpdateRecipeController {
//@formatter:off
 @Operation(
     summary = "Update recipe",
     description = "Returns updated recipe",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "The recipe was updated", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Recipe.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are wrong", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "The recipe componenets were not found", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "Unplanned error", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(name = "RecipeName",
             required = true,
             description = "Name of the Recipe to be Updated"),    
         @Parameter(name = "cooked",
         required = true,
           description = "Has Been Cooked?")  
     }
 )
//@formatter:on
 
@PutMapping
@ResponseStatus(code = HttpStatus.OK)
 
Recipe createRecipe(@RequestParam String RecipeName,
                    @RequestParam boolean cooked);
  
  
}
