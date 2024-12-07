# Minutes of Meeting 5 (7/12/2024)
## Reiterated importance of our workflow:    
1. everyone pulls before the rebase
2. confirm there's no uncommitted changes on their local big branch
3. do the rebase on the `main`
4. everyone git pulls (to update their local repositories)

## Agenda
__MS__
- Write up completion calculations:
  - Create completion ranges:
    - `100% complete`
    - `70-100% complete`
    - Below `70%` (not displayed)
  - Compare quantities in the fridge to recipe requirements and calculate the average for all ingredients.
- Write a `SELECT` statement to extract data and store it in variables.
- Discuss and finalise variable names with LT.
- Consider adding a units column for measurements (e.g., grams, tbsp, mL).

__LT__
- Use the JDBC driver to connect Java to PostgreSQL.
- Process MS’s SQL queries in the backend.
- Ensure data flows correctly from the backend to the GUI.
- Collaborate with MS on variable naming conventions.

__LD__
- Redesign GUI
    - Adjust GUI design to:
    - Exclude recipes with completion below `70%`.
    - Remove weight/qty fields to align with simulated recipe data.
    - Coordinate with MS to ensure compatibility between the GUI and the database.
- Delete and recreate the `UI` branch for a fresh start.
    - Create skeleton files on `UI` branch 
- Begin implementing GUI

__PF__
- Update the Kanban board 
- Update `.github/workflows` to support multiple Java versions.
- Begin preparing for Docker containerisation of the backend.
- Research testing strategies for containerised environments.
- Contribute to Week 2 requirements analysis and documentation.

## Minutes and Updates
- Discussed workflow for PRs and reinforced the need for consistency:
  1. Pull before rebasing.
  2. Ensure local branches are clean (no uncommitted changes).
  3. Rebase on `main`.
  4. Pull from `main` post-rebase to sync local repositories.
- Agreed to delete and recreate the `UI` branch as LD didn't make any commits to it yesterday, so to ensure consistency with the root directory `main`.
- Collaboration updates:
  - MS and LT will finalise database variable names.
  - MS to help LD with GUI design with database output.
