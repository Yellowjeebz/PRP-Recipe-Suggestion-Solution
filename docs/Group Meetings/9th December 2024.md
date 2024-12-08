# Minutes of Meeting 7 (9/12/2024)
## Starting the day
Fridge-integration needs to be pushed to main, so that the updated docker.yml CI workflow will start working. This should start making docker images which is what LT needs.

## Agenda / To Dos
__LT__
- (Recipe Categorisation)  
    - Work with MS to use her queries along with some code to finish producing a list of complete and semi-complete recipes
- (Shopping Lists) 
    - Create a shopping list for every semicomplete recipe

__MS__
- (Recipe Categorisation)  
    - Work with MS to use her queries along with some code to finish producing a list of complete and semi-complete recipes
- (Shopping Lists) 
    - Create a shopping list for every semicomplete recipe
- Work with LD to create an output of arrays that feeds into the input of the frontend 


__LD__
- Continue working on the GUI
    - Create a screen that has two halves:
        - Left: displays the recipes, listing as complete at the top, and semi-complete underneath (these will just have recipe titles, no other information about steps or ingredients)
        - Right: displays Fridge Contents (each item has "name - expiry")
    - Create a button that when you click on a recipe:
        - Left: stays the same (the left is made up of recipes which are secretly buttons that trigger a change on the right of the screen)
        - Right: Detailed recipe (name, steps, ingredients), and under this the shopping list page for that recipe (nothing for complete, and the ingredients+qty missing for semi-complete)
- Aspirationally, create a button that opens up a separate page/window for the detailed recipe view
- Aspirationally, update the styling file so it looks nicer

__PF__
- Finalise Docker functionality so that this works
    - https://bham.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=3c4394a0-8c75-43ac-b9f4-b23500b55976 (40:01)
- Support with backend/frontend implementation with LT/MS or LD respectively, if required
- Finish requirements analysis 
- Start writing bullet points for the report
- Aspirationally, fix custom CI Workflows (in `.github/workflows`) run on GitHub actions page
