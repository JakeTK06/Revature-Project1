# Sprint RetroSpective
## What went well?
The project as a whole went pretty smoothly considering I had to learn new technologies to complete it and sometimes there can be a bit of a learning curve when starting with a new technology. The planning of the project went very well and enabled the rest of the project to move along smoothly, putting a lot of time in planning by using the RTM and Jira board was very useful later on in the project once test cases were being written. The use of IntelliJ for programming the project went well, IntelliJ was a great tool to help build this test suite and abstracted away some stuff that would have been confusing for someone building their first test application. Using Cucumber and Selenium also went very well, they are two technologies that were easy to pick up and do a lot of the heavy lifting in terms of building the boilerplate code, and they also have a lot of documentation online for places I got stuck. Another decision that worked out well was how Page Object Models were utilized, by keeping the functions that interact with a page in one java file it makes it easier to use and reduces repetitive across different test cases. 

## What needs to be improved upon?
Due to this type of project being something I haven't done before there is a lot to learn from. One step of the process I would like to focus my improvement on is writing the initial test criteria with the tests in mind. When they were initially written I didn't know yet how the tests would look or be implemented so there were some missteps. While working through writting test cases I realized some of my steps were somewhat repetitive and would end up testing the same thing. For example the adding planets and moons user story I had a Then step "Then the table should refresh" as well as "Then the user should see their added planet/moon", I realized while building out those test steps that I would be testing the same thing for each step because to test the table refresed I was testing that the new celestial was being shown. Along with having repetitive steps I noticed I had reused some then statements that were going to be different checks for the different scenarios so I had to go back and make those steps more explicit. Improving on writing the initial criteria should help cut down on the biggest time sink I had in the project where I had to go and update my RTM and Jira board for all of the small mistakes I needed to fix. I also have a better idea of clarifying questions to ask the client based of a wireframe provided because there seems to be a difference between how I interpreted the order of operations on the wireframe and the order of operations that are implemented. 

## What still needs to be accomplished?
For the next sprint there are some more edge cases I would like to explore on the testing side, as well as some improvements I think could be made. My tests currently only validate that planets and moons can be created with a valid file path by checking they can be created with no image set. Since there is only one other option that is valid I would like to build another test case to make sure that scenario works as well. Another edge case I would like to check is to make sure other logged in users cannot view other users planets and moons. Currently we only check that users can see their own planets and moons and that logged out users cannot see any planets and moons, but there is no check to make sure planets and moons are only seen by the person that added them. Then there are some improvements I would make to the current code, I would like to look into if selenium has the possibity to cache login credentials then make sure they are on the homepage by going directly there. This would just ensure that users are logged in and on the right page and would not have to worry about making sure the login button takes them there in the event that future additions to the application break that functionality. I would also like to go through all of my shared steps and make sure they are all in the same file currently there is only the alert step but there could be a couple more. Lastly I would like to add a cucumber hook to reset the user logged in to being logged out after a test.  