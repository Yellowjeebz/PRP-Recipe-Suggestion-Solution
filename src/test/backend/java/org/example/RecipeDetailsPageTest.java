package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.TerminalOutput.RecipeDetailsPage;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeDetailsPageTest {

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
    public void testRecipeDetailsContentsPage() {


       RecipeDetailsPage.main(new String[]{});
        String[] expectedlines = {"Eggy Bread" ,
                        "Instructions:" ,
                        "1. Beat together the egg with milk and a generous amount of salt and pepper in a shallow bowl." ,
                        "2. Heat enough oil to just cover the bottom of a large frying pan over a medium heat. When the oil starts to shimmer dip the bread into the egg mixture and add it to the pan. Cook for 5 minutes on each side or until golden-brown.", 
                        "3. Serve with tomato ketchup or brown sauce." ,
                        "Ingredients:" ,
                        "1  egg" ,
                        "15ml milk" ,
                        "2g cream cheese", 
                        "2tsp salt" ,
                        "2tsp pepper"};
        
                     String expectedOutput = buildExpectedOutput(expectedlines).trim();
                    String actualOutput = outputStream.toString().trim(); 

                    String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
                    String normalizedActualOutput = actualOutput.replace("\r\n", "\n").replace("\r", "\n");


                    assertEquals(normalizedExpectedOutput, normalizedActualOutput, "The output of Recipe selection page does not match the expected output.");
    }
}