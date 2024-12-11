package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.TerminalOutput.RecipeSelectionPage;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeSelectionTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to a ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreSystemOut() {
//clears for next test
        System.setOut(originalOut);
    }
    private String buildExpectedOutput(String[] lines) {
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }

    @Test
    public void testRecipeSelectionContentsPage() {


       RecipeSelectionPage.main(new String[]{});
        String[] expectedlines = {"Connected",
"Complete Recipes- These are the recipes that you have all of the ingredients for!",
"Cheese and ham omelette",
"Moroccan style roasted veg",
"Eggy Bread",
"Semi-complete Recipes- These are the recipes that you have most of the ingredients for!",
"Ham and cheese toastie",
"Cacio e pepe",
"Pesto and Cheese Rice",
"Broccoli Pasta"};
        
                     String expectedOutput = buildExpectedOutput(expectedlines).trim();
                    String actualOutput = outputStream.toString().trim(); 

                    String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
                    String normalizedActualOutput = actualOutput.replace("\r\n", "\n").replace("\r", "\n");


                    assertEquals(normalizedExpectedOutput, normalizedActualOutput, "The output of Recipe selection page does not match the expected output.");
    }
}