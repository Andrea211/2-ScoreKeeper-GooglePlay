
# *ScoreKeeper*  

**ScoreKeeper** is an app to track scores between two teams within a baseball game.


## Layout:

* The chosen game has multiple amounts of points that can be scored, such as field goals, touchdowns, tries, safeties.
* App is divided into two columns, one for each team.
* Each column contains a large TextView to keep track of the current score for that team.
* Each column contains multiple buttons. The buttons track a different kind of scoring.
* The layout contains a ‘reset’ button.
* The code adheres to all of the following best practices:
	* Text sizes are defined in sp
	* Lengths are defined in dp
	* Padding and margin is used appropriately, such that the views are not crammed up against each other.

Optionally, a second TextView to track how many times a button was clocked is added.

## Functionality:

* The code runs without errors.
* Each score button updates the score TextView in its column by adding the correct number of points.
* The reset button resets the scores on both of the score TextViews.

## Code Readability

* Any classes are named after the object they represent. All variables are named by their intended contents.
All methods are named by their intended effect or in the style required by a callback interface.
* There are no unnecessary blank lines. One variable is declared per declaration line.
The code within a method is indented with respect to the method declaration line.

## Overview of the app 

