package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FridgeContentsPageTest {

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
    public void testFridgeContentsPage() {


       FridgeContentsPage.main(new String[]{});
        String[] expectedlines = {"3  egg     exp:2025-06-09",
                        "14g unsalted butter     exp:2025-06-20",
                        "42g cheese     exp:2025-06-21",
                        "40g ham     exp:2025-06-22",
                        "10tsp salt     exp:2025-06-01",
                        "10tsp pepper     exp:2025-06-11",
                        "400g spaghetti     exp:2025-06-12" ,
                        "0tsp mustard     exp:2025-06-14",
                        "15g broccoli     exp:2025-06-30" ,
                        "14g plain flour     exp:2025-06-04" ,
                        "105ml milk     exp:2025-06-09" ,
                        "1tbsp curry paste     exp:2025-06-20" ,
                        "280g chickpeas     exp:2025-06-21" ,
                        "161g chopped tomatoes     exp:2025-06-22" , 
                        "17g  creamed coconut     exp:2025-06-01" ,
                        "87g rice     exp:2025-06-11" ,
                        "2  red pepper     exp:2025-06-12" ,
                        "2  sweet potato     exp:2025-06-14" ,
                        "2  red onion     exp:2025-06-30" ,
                        "200g cherry tomatoes     exp:2025-06-04" ,
                        "210tbsp harissa     exp:2025-06-09" ,
                        "2tbsp olive oil     exp:2025-06-20" ,
                        "200g pesto     exp:2025-06-21" ,
                        "15g pasta     exp:2025-06-22" ,
                        "45g cream cheese     exp:2025-06-01" ,
                        "2  slices of bread     exp:2025-06-11"};
        
                     String expectedOutput = buildExpectedOutput(expectedlines).trim();
                    String actualOutput = outputStream.toString().trim(); 

                    String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
                    String normalizedActualOutput = actualOutput.replace("\r\n", "\n").replace("\r", "\n");


                    assertEquals(normalizedExpectedOutput, normalizedActualOutput, "The output of FridgeContentsPage.main() does not match the expected output.");
    }
}