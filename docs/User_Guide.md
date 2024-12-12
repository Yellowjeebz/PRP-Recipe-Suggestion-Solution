# Running RSS

## Prerequisites

1. **Install Docker**  
   Download and install Docker Desktop for your operating system:  
   - [Docker Desktop for Windows](https://www.docker.com/products/docker-desktop/)
   - [Docker Desktop for macOS](https://www.docker.com/products/docker-desktop/)
   - For Linux, refer to your distribution's instructions on website.
     
2. **Cloning the Repository** 
   Clone the repository on to your local device:
   
   `git clone https://github.com/Yellowjeebz/PRP-Recipe-Suggestion-Solution`

   and navigate to the root directory:
   
   `cd PRP-Recipe-Suggestion-Solution`

   
   
## Running the Program 
   In the root directory run:
   
   `docker-compose up --build`

   This will: 
   - Build and start the postgreSQL database
   - Build and start the Spring Boot backend 
   - Build and serve the React Frontend 
   
## Accessing the Application 
  Open your browser and enter:
  http://localhost:3000


