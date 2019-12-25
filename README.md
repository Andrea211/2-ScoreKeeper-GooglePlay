# *ScoreKeeper*  

<p align="right">
	<a href="https://play.google.com/store/apps/details?id=com.neonfunapps.scorekeeper" rel="nofollow">
    <img alt="Get it on Google Play" height="80" src="https://camo.githubusercontent.com/59c5c810fc8363f8488c3a36fc78f89990d13e99/68747470733a2f2f706c61792e676f6f676c652e636f6d2f696e746c2f656e5f75732f6261646765732f696d616765732f67656e657269632f656e5f62616467655f7765625f67656e657269632e706e67" data-canonical-src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" style="max-width:100%;">
</a>
</p>

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

<p align="center">
  <img src="https://raw.githubusercontent.com/Andrea211/2-ScoreKeeper-GooglePlay/master/1-6%20inch%20-%20Nexus%206-screen__1.jpg" width="200" title="hover text">
	<img src="https://raw.githubusercontent.com/Andrea211/2-ScoreKeeper-GooglePlay/master/2-6%20inch%20-%20Nexus%206-screen__1.jpg" width="200" title="hover text">
	<img src="https://raw.githubusercontent.com/Andrea211/2-ScoreKeeper-GooglePlay/master/2-6%20inch%20-%20Nexus%206-screen__2.jpg" width="200" title="hover text">
	</p>
	<p align="center">
	<img src="https://raw.githubusercontent.com/Andrea211/2-ScoreKeeper-GooglePlay/master/3-6%20inch%20-%20Nexus%206-screen__3.jpg" width="200" title="hover text">
	<img src="https://raw.githubusercontent.com/Andrea211/2-ScoreKeeper-GooglePlay/master/3-6%20inch%20-%20Nexus%206-screen__3.jpg" width="200" title="hover text">
</p>

