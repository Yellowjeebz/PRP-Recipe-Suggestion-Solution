
## 25/11
Set up the Github repository and downloaded IDEs and other tools for the project
## 02/12
Set up database and github ready for production, discussed delegating work and team member responsibilities
## 04/12
MS (with support from LT): Changed the database from the initial EDR design to make more sense as a relational database 
- added new tables to ensure 3NF, avoid data redundancy
- renamed fields to ensure consistency

LT: Began to look at backend and testing approached

PF: Edited README and started to break down work into units, re-familiarised with brief and set Success Criterias

LD: Began drafting ideas for the GUI/Frontend
## 06/12
LD
- Sketched an overview for the GUI 
    - Window with two smaller windows - one for recipes, one for fridge contents. 
    - The recipe part shows complete recipes first then semi-complete. 
    - When you click on recipe, smaller will pop up in the middle with recipe steps on the left and ingredients on the right.
- Installed React and Node.js ready to set up tomorrow and begin implementation

MS
- Populated csv files with recipe table, ingredients table and recipe_ingredients tables. Only a short amount of data with 10 student recipes. Used student recomended recipes from bbc good food to simulate the list of recipes.

- Populated fridge_contents file
	- Made calculations of what quantities of each ingredient should be in the fridge for Min Briggs 
		○ Ensured there were certain number of recipes that would be classed as complete, semi complete and incomplete. This will be useful for testing to check that the categorising of data works.
	- Only populated the student_house table with information from 2 houses (rest are irrelevant as this is just a simulation of real data)
	- Only populated fridge contents with information about 2 students (rest are irrelevant as we are just running the system for one student in this prototype)
	- ( we decided to make the prototype to just run for one student in the house, in a later iteration we could extend the project so other students will be able to use the recipe system)

PF
- Updated Group Meeting Notes to ensure we are providing organised updates on our work and planned work. 
- Deleted 'main-changes' branch as this was not necessary as a new branch + PR can be made for small changes to the main (root directory)
- Made a CI workflow which is found in the root GitHub directory in "./github/workflows"
    - This automates building, testing, and validating the project via GitHub Actions (using Gradle which LT set up)
- Organised the Kanban to ensure it was up to date 
    - though meeting up in person and discuss is easier, good to be able to visualise work units to do 

LT
- Set up build tools
    - Set up Gradle ready for backend development.
    - Gradle will be used for testing and using libraries to connect the frontend and database together
    - Set up the build to work in our repository environment

## 07/12
LD:
- Added React to the repository
- Made a template GUI

MS: 
- Fixed an issue where when csv put into psql, get a '/r' at the end and some characters go wrong. '-' becomes something else.
- Approved PRs relating to database from LT and vice versa
- Integration testing with csv files
	- Put database -> psql
	- Writing sql statements
- Discussed layout with LD to help him understand the improvements to viability made to the EDR ie which data he needs to include in the interface design

LT:
- Considered whether to continue development to work just to the versions LT's local device (for now hardcoding credentials), or making it work on all different versions
    - Considered the fact that this is just a prototype / proof of concept. 
    - LT will for now make it just work on his device. Later, once the code works, then we will focus on it working on all systems, using containerisation.
- Started on test-driven development - started writing Junit tests

PF 
- Approved most PRs to main
- Added docker ready for containerisation of LT's work
    - Builds using Gradle implemented by LT
- Redesigned LD's GUI sketches
- Custom workflows to GitHub Actions
- Kept Kanban up to date, ensuring that issues are assigned to the corresponding Group member

Extra Notes:
- We when first developing did the 3-branch method. but now with integration ,we need to use each others code so we are using 1 dev branch instead.
    - we didn't want to push to main until we knew everytihng worked.
    - started on 3, then moved to 1 dev branch (fridge-integration)
- Great use of naming conventions 'feature/' for new branches when adding features
    



