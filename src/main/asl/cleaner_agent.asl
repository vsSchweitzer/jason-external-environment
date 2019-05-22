// It starts believing that it does not carry any trash
~carryingTrash.

// It starts wanting to know the location of the trash can
!findTrashCan.

// Whenever it believes there is trash at (X, Y), it will desire to clean (X, Y)
+trash(X,Y) <-
	!clean(X,Y).

// Whenever it believes that it is carrying trash, it will desire to dispose of it
+carryingTrash <-
	!dispose.

// Plan to pickup trash
+!findTrashCan : ~trashCan(_,_) <-
	locateTrashCan.

// Plan to pickup trash
+!clean(X,Y) : ~carryingTrash <-
	moveTo(X,Y);
	pickupTrashAt(X,Y).

// Plan to dispose of trash
+!dispose : carryingTrash & trashCan(X,Y) <-
	moveTo(X,Y);
	disposeTrash.
	
// Plan to find the trash can
+!findTrashCan : not trash(_,_) <-
	scanSurroundings;
	!findTrashCan.
