// It starts wanting to know the location of the trash can
!findTrashCan.
!findTrash.

// Whenever it believes there is trash at (X, Y), it will desire to clean (X, Y)
+trash(X,Y) <-
	!clean(X,Y).

// Whenever it believes that it is carrying trash, it will desire to dispose of it
+carryingTrash <-
	!dispose.
	
// Plan to find the trash can
+!findTrashCan <-
	locateTrashCan.
	
// Plan to pickup trash
+!clean(X,Y) : not carryingTrash & not busy <-
	add_belief(busy);
	moveTo(X,Y);
	pickupTrashAt(X,Y);
	drop_belief(busy).

// Plan to dispose of trash
+!dispose : carryingTrash & trashCan(X,Y) & not busy <-
	add_belief(busy);
	moveTo(X,Y);
	disposeTrash;
	drop_belief(busy).

// Plan to find trash
+!findTrash : not trash(_,_) <-
	scanSurroundings;
	!findTrash.