# Software Requirements Specification
## Functional requirements: what the software should do
Take contents of a fridge that THEY own and provide a list of potential recipes using these ingredients
1. Using fridge contents, provide users with recipes categorised as Complete (all ingredients available) or Semi-Complete (some ingredients missing)
2. For Semi-Complete, provides a shopping list of items + qty of items missing from these suggested recipes


## Non-functional requirements: qualities of the software
The software that implements this prototype should have the qualities to prove that the EDR is indeed viable.
We
■ Example: The result of addition must be displayed within less than a second.
■ Things to consider: accessibility, availability, performance, security, usability, .


## "Simulating" other parts of the overall SSH System
### SSH Camera
#### Features of SSH Camera we can "simulate":
• By pointing the _SSH Camera_ at the fridge, it can detect who takes what from the fridge. 
• The _SSH Cloud_ (subscription required) will then automatically bill users for items they have taken, but were’t theirs (we can use this functionality to instead track who owns what for recipes).
    
### The SSH Hub - First Class 
#### We can't "simulate" the  but simulating the SSH Hub isn't necessary to prove the feasibility of the proposition of SSH RSS
It is too overcomplicated for a first prototype to consider other SSH products in the home. SSH Hub connects other SSH products in the home as a USB-powered device which connects devices via Bluetooth or WiFi to the SSH Cloud (via WiFi).
Using abstraction, we shall not consider how the SSH RSS would be implemented into the SSH Hub, as this is not as important to prove viability of this product as features such as being able to work with outputs from the SSH Camera.
• Networking: runs software which detect SSH products in range, communicates with them, and propagates information between the SSH Cloud and those devices,
    
    
### Features of SSH Cloud we can "simulate": 
Includes both a web-based interface for users to:
- access to manage their accounts
- remote-control their devices, as well as services that exchange information with the SSH Hubs.
## MoSCoW
### Must have
### Should have
### Could have
### Won't have
