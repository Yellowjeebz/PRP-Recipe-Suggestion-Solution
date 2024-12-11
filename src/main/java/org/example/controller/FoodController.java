package org.example.controller;

import org.example.service.FridgeContentsService;
import org.example.service.RecipeDetailsService;
import org.example.service.RecipeSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class FoodController {

    private final FridgeContentsService fridgeContentsService;
    private final RecipeSelectionService recipeSelectionService;
    private final RecipeDetailsService recipeDetailsService;

    @Autowired
    public FoodController(FridgeContentsService fridgeContentsService, 
                          RecipeSelectionService recipeSelectionService, 
                          RecipeDetailsService recipeDetailsService) {
        this.fridgeContentsService = fridgeContentsService;
        this.recipeSelectionService = recipeSelectionService;
        this.recipeDetailsService = recipeDetailsService;
    }

    @GetMapping("/fridgeContents")
    public ResponseEntity<List<String>> getFridgeContents(@RequestParam(name="studentId", defaultValue="3") int studentId) {
        List<String> contents = fridgeContentsService.getFridgeContents(studentId);
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/recipes/complete")
    public ResponseEntity<List<String>> getCompleteRecipes(@RequestParam(name="studentId", defaultValue="3") int studentId) {
        List<String> complete = recipeSelectionService.getCompleteRecipes(studentId);
        return ResponseEntity.ok(complete);
    }

    @GetMapping("/recipes/semicomplete")
    public ResponseEntity<List<String>> getSemiCompleteRecipes(@RequestParam(name="studentId", defaultValue="3") int studentId) {
        List<String> semi = recipeSelectionService.getSemiCompleteRecipes(studentId);
        return ResponseEntity.ok(semi);
    }

    @GetMapping("/recipeDetails")
    public ResponseEntity<List<Object>> getRecipeDetails(@RequestParam(name="studentId", defaultValue="3") int studentId,
                                                              @RequestParam(name="recipeName") String recipeName) {
        List<Object> details = recipeDetailsService.getRecipeDetails(studentId, recipeName);
        return ResponseEntity.ok(details);
    }
}
