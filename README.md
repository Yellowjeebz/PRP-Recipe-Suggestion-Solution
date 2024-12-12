# PRP-Recipe-Suggestion-Solution
A smart home solution for taking food in your fridge and suggesting recipes from the food available.

[The user guide can be found here:](docs/User_Guide.md)

## **Project Overview**  
This project is for developing the **Recipe Suggestion Solution (RSS)** for the Student Smart Homes (SSH) ecosystem. 

The goal of SSH RSS is to help students optimise their meal preparation by leveraging smart home devices like the SSH Camera and SSH Cloud. The solution identifies available ingredients in the fridge, suggests complete or semi-complete recipes, and generates shopping lists for missing ingredients.  

### Keeping track
Screenshots: https://docs.google.com/document/d/1rPDiQx314RmUi7b1leXQcHVeWyWl4evqL6dzKL6eDlM/edit?usp=sharing 

#### Documentation
[Engineering Design Review (EDR)](docs/LukeThornley%20EDR%20-%202398180.pdf)

[Log of progress](docs/activityLog.md)

---

## Workflow:

### Daily Workflow
**Group Meeting** - discussing units of work and what is to be tackled today. Ensure all 'feature' branches are up to date (have PR from the main). This is recorded in 'meeting notes' found in `docs/Group Meetings`

**Independent Work** - working locally, each group member works on their 'Unit'.

**Activity Log Update** - at the end of the day, each member writes down their work in `docs/activityLog.md`

---
### Branching
- Create 3 branches from the main branch - these will be maintained rather than deleting when making PRs from them:
  1. **`frontend`**: All front-end changes (e.g., GUI/React.js).
  2. **`backend`**: All back-end changes (e.g., database connections, business logic in Java or Python).
  3. **`database`**: Any changes to database schemas or configurations.
  
  ^ While members primarily focus on their respective 'major units', they can contribute to other branches if required. Changes should be submitted through pull requests for the relevant branch.

### PRs
-  **Making changes**:
   - Changes must be submitted through a **pull request (PR)** into the  respective branch (frontend, backend, database).
   - Do NOT make changes directly to any branch without a pull request.
   - Pull requests to the `main` branch are only allowed through `frontend`, `backend`, and `database` branches when changes have been tested and approved.
   - Small changes to `main` will be made with the `main-changes` branch.

-  **Approval Workflow**:
   - Every pull request must be approved by PF/a peer, especially for the `main`, checking:
     - **the code works and makes sense with the rest of the project** 
     - **writeup/message and style** matching set project conventions, matching the rest of the project and the EDR design.
    

- **Pull Request Template**:
     When making PRs/commits, write with as much detail and explanation as to why the changes you've made have been implemented. 
     Branches should following naming conventions (i.e. feature/fridge-database-patch-CSV) so that this can be tracked in the history log of closed PRs/commits.
     Write info in the template as follows:

#### Contribution Guidelines (Things to consider/include):
     Brief summary of the changes made
     Unit / Kanban task it relates to
     Testing Performed (if any)
     Other areas that this change may impact (if any)
     Anyone who should review this work
     
   Checklist before making PRs/Commits: 
     - Tests have been written/updated where necessary.
     - Documentation has been updated (if applicable).
     - Feature/branch you're PRing to has been merged with the latest `main` or at least latest `database`/`frontend`/`backend` branch.

## Testing Guidelines
#### Frequent Testing:
   - Create tests when implementing a new feature.
   - Run these tests before making a PR that makes significant changes in a feature branch.
   - Tests must pass before creating a pull request to merge into `main`.

## Key Features:

### **IDEs / Languages Used**  
#### **IDEs**:  
- IntelliJ (Frontend & Backend).  


#### **Languages**:  
- **Backend**: Java
- **Frontend**: Java
- **Database**: SQL for relational data.  

### **Project Responsibilities**  
#### **Team Members and Roles**  
- **GitHub, Containerisation and Project Manager-** Phoebe Farrelly
- **Database Lead-** Maya Sahota
- **Lead Developer-** Luke Thornley
- **GUI Designer-** Luke Deery


### **Modules/Sections of project and Responsbilities**  
- **Fridge Content Management**: 

---

## **Deadlines and Unit Goals**  
| **Milestone**             | **Task/Subunit**                                                | **Deadline**       |
|---------------------------|--------------------------------------------------------|--------------------|
| Milestone A               | ~~Design Database~~                                        |(02/12) Done|
| Milestone B               | ~~Populate database with fridge and recipe data~~          |(06/12) Done|
| Milestone C               | Develop backend logic for recipe categorisation  |07/12|
| Milestone D               | Develop backend logic for personalised shopping lists  |07/12|
| Milestone E               | Create UI for recipe suggestions based on fridge contents  |07/12|
| Milestone F               | Create UI for shopping lists  |07/12|
| Milestone G               | Create UI for detailed recipe views  |08/12|
| Milestone H               | Testing and optimisation for deployment                | Ongoing, but final testing to be done by 10/12|
| Milestone I               | Project to be containerised             |09/12|
| Milestone J               | Completed Implementation             |09/12|
| Milestone K               | Project Summary + Report            |10/12-11/12|
| Milestone L               | Individual Project Reflections            |11/12-12/12|

---

## **Other Notes**
- **Dependencies**:
  - Libraries: Picocli
- **Testing Frameworks**:  
  - Gradle
