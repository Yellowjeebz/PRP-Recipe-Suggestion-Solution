# Minutes of Meeting 5 (6/12/2024)
## Discussed workflow going forward:    
Start the day with a ```git pull``` from the main branch to local clone repositories.

Then, work on your files on VSCode, commit changes when ready to upload

    checkout to main branch
    git pull origin main
    go to branch you were working on
    git rebase [base branch of the branch you were working on]
    push


## Agenda
__MS__
- Convert excel files of "simulated" output from online recipe extraction APIs into CSV files
- Create calculations for fridge contents ready for testing based on the calculations of "completion" as per the chosen EDR

__LT__
- Add Gradle to the `fridge-backend` branch
- Begin coding the backend functionality

__LD__
- Continue designing GUI
- Create skeleton files on `fridge-frontend` branch 
- Begin implementing GUI

__PF__
- To supplement group members that need support with coding or GitHub
- Organise GitHub logs
- Ensure no conflicts with commits
- Begin preparing for containerisation with Docker
- Help with testing and observability
- Begin report

## Minutes and Updates
Went through on the whiteboard our workflow for PRs. (see screenshots)

At the end of the day, we will ensure that all remote feature branches make a PR to main, so that when you pull from main it is the latest. 