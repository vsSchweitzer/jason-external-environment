// It starts wanting to know the location of the trash can
!findTrashCan.
!findTrash.

// Whenever it believes there is trash at (X, Y), it will desire to clean (X, Y)
+trash(X,Y) : not .desire(clean(_,_)) <-
	!clean(X,Y).

// Whenever it believes that it is carrying trash, it will desire to dispose of it
+carryingTrash <-
	!dispose.
	
// Plan to find the trash can
+!findTrashCan <-
	locateTrashCan.
	
// Plan to pickup trash
+!clean(X,Y) : not carryingTrash & not busy <-
	moveTo(X,Y);
	pickupTrashAt(X,Y).

// Plan to dispose of trash
+!dispose : carryingTrash & trashCan(X,Y) & not busy <-
	moveTo(X,Y);
	disposeTrash;
	!findTrash.

// Plan to find trash
+!findTrash : trash(X,Y) <-
	!clean(X,Y).
+!findTrash : not trash(_,_) <-
	scanSurroundings;
	?not trash(_,_);
	!findTrash.
	