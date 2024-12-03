***FileLineFinder***
-------------------------

How to run program
---
1. PLEASE RUN THIS PROGRAM IN INTELLIJ IN ORDER TO USE SPOTBUGS AND JACOCO.
 
How to run Static Analysis Tool (Spotbugs) ->
First you must downlad 


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
- 