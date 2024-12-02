# PRP-Recipe-Suggestion-Solution
A smart home solution for taking food in your fridge and suggesting recipes from the food available.

## **Project Overview**  
This project is for developing the **Recipe Suggestion Solution (RSS)** for the Student Smart Homes (SSH) ecosystem.  

The goal of SSH RSS is to help students optimise their meal preparation by leveraging smart home devices like the SSH Camera and SSH Cloud. The solution identifies available ingredients in the fridge, suggests complete or semi-complete recipes, and generates shopping lists for missing ingredients.  

### Keeping track
Screenshots: https://docs.google.com/document/d/1rPDiQx314RmUi7b1leXQcHVeWyWl4evqL6dzKL6eDlM/edit?usp=sharing 

#### Documentation
[Engineering Design Review (EDR)](src/docs/LukeThornley%20EDR%20-%202398180.pdf)

[Log of progress](src/docs/activityLog.md)

### Workflow Plan:
- Create 3 branches from main:
  1. frontend (all front-end changes - GUI/React.js) 
  2. backend (all back-end changes - Connecting database and GUI/java or python)
  3. database (any changes to the database configuration)
 
  ^ Any members (though working predominantly on their respective area), can independently work on the tasks on each branch, submitting pull requests to the respective branch to the work they've done.

Team should **submit a pull request** to the **respective branch** after making changes, and do NOT make changes without a pull request - and should only make pull requests to main.

Only once frontend, backend, and database are complete then we merge these into main (at the end) via pull requests. 

Regularly update frontend/backend/database as we go, main right at the end.

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
- **Git and Project Manager-** Phoebe Farrelly
- **Database Lead-** Maya Sahota
- **Lead Developer-** Luke Thornley
- **GUI Designer-** Luke Deery


### **Modules/Sections of project and Responsbilities**  
- **Fridge Content Management**: 


---

## **Deadlines and Goals**  
| **Milestone**             | **Task**                                                | **Deadline**       |
|---------------------------|--------------------------------------------------------|--------------------|
| Milestone 1               | Design Database                                        ||
| Milestone 2               | Populate database with fridge and recipe data          ||
| Milestone 3               | Develop recipe categorisation and shopping list logic  ||
| Milestone 4               | Create UI for fridge contents and recipe suggestions   ||
| Milestone 5               | Testing and optimisation for deployment                ||

---

## **Other Notes**
- **Dependencies**:
  - Libraries: 
- **Testing Frameworks**:  
  - JUnit
