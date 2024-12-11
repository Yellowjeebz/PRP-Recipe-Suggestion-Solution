package org.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FridgeContentsService {

    private final JdbcTemplate jdbcTemplate;

    public FridgeContentsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getFridgeContents(int studentId) {
       

        List<String> fridge_ingredient_names = new ArrayList<>();
        List<String> fridge_ingredient_quantities = new ArrayList<>();
        List<String> fridge_ingredient_dates = new ArrayList<>();
        String sql = "SELECT fridgecont.fridge_ingredient_ID, ing.ingredient_units, ing.ingredient_name, fridgecont.ingredient_quantity, fridgecont.ingredient_date FROM fridge_contents fridgecont JOIN ingredients ing ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE fridgecont.student_ID = ?;";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, studentId);

            for (Map<String, Object> row : rows) {
                fridge_ingredient_names.add((String) row.get("ingredient_name"));
                fridge_ingredient_dates.add(row.get("ingredient_date").toString());
                fridge_ingredient_quantities.add(row.get("ingredient_quantity") + "" + row.get("ingredient_units"));
            }

            //  System.out.println("ingredient      quantity        dates");

            List<String> fridgeEntries = new ArrayList<>();
            for (int i = 0; i < fridge_ingredient_names.size(); i++) {
                fridgeEntries.add(fridge_ingredient_quantities.get(i)+" "+fridge_ingredient_names.get(i)+" exp:"+fridge_ingredient_dates.get(i));
            }

            return fridgeEntries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
