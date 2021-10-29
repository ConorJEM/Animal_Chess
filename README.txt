Within the Test directory I just have a few simple tests relating to two things:
First; I realised that I was passing all the tests before I implemented the 'direction' variable for the
cat class, meaning that both players cat pieces were 'facing' the same way. So I wrote some tests to ensure that the 
cat is now has the desired legal moves.
Second; I added a throw error exception for if a player was created with a playerNumber that wasn't either 0 or 1, and tested that
this would now correctly throw an error.

My only difference from the UML diagram is the inclusion of an extra setter method in the Piece class called 'setSquare'
that allowed me to keep the square variable of a piece private.