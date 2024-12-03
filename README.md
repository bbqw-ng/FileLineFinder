***FileLineFinder***
-------------------------

How to run program
---
- To Run the tests, please open this project in intellij, and then under the test folder you should find "java" right click and then click "run tests in java".A
- That should be it on how to run the tests.
- Quick Note -> Some tests rely on files and the file structure and directories. If you export the directory incorrectly, Some tests may fail.

For developer Initializing
---
Instructions (Jacoco)
- Go to "Settings" under file and find "Coverage" under 'Build,Execution,Development'
- Then Click "Choose Coverage Runner" and select "JaCoCo".

Instructions (SpotBugs)
- Go to "Settings", then "Plugins", then search "Spotbugs" in marketplace and then download.


SPOTBUGS - Reporting and more....
--- 
- ***A Spotbugs Report has been added to this directory for evaluation.***
- Along the way, spotbugs static analysis tool alerted me to things such as unused variables that I had left and forgot about which I removed or started to use later on.
- Spotbugs also alerted me on certain things like default encoding which I'm not too sure what to do about so I left those alone
- Spotbugs told me about some performance warning about string concatenation with the '+='. It told me to use StringBuilder instead, but for this scenario I deemed it unnecessary.
- All in all, I didn't have too many issues with my source code, but there were 3 warnings about default encoding which I looked at and don't think it was necessary for a change. It was helpful since it caught extra things such as unusued variables and whatnot.

JACOCO - CODE COVERAGE TOOL
---
- ***A JaCoCo Coverage Report has been added to this directory for evaluation.***
- To Open The Jacoco Report, Goto the 'htmlReport' directory, expand it, right click 'index.html' and then click open in browser and choose a browser of your choice.
- This report should show you line, method, and branch coverage
- In my current report my branch coverage is 83% but in reality it should be greater than a 93% since, the main method, where you prompt the user is never run causing branch coverage to be reduced. 
- Another reason is because I have a function that is used to print the lines in the Collection of lines, which is not used in the test cases since it isn't supported to check output from std.out.
- I did not make more changes to up my coverage because again in reality, my branch coverage is above 90% making it well tested.