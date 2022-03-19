package com.promineotech.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/deleterecipe")
@OpenAPIDefinition(info = @Info(title = "Delete Recipe"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface DeleteRecipeController {
//@formatter:off
 @Operation(
     summary = "Delete recipe",
     description = "Returns deleted recipe",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "The recipe was deleted", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Recipe.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are wrong", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "The recipe was not found", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "Unplanned error", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(name = "RecipeName",
             required = true,
             description = "Name of the Recipe to be deleted"),    
 
     }
 )
//@formatter:on
 
@DeleteMapping
@ResponseStatus(code = HttpStatus.OK)
 
Recipe deleteRecipe(@RequestParam String RecipeName
                    );
  
  
}
