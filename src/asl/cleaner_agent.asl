// It starts wanting to know the location of the trash can
!findTrashCan.
!findTrash.

// Whenever it believes that it is carrying trash, it will desire to dispose of it
+carryingTrash <-
	!dispose.
	
// Plan to find the trash can
+!findTrashCan <-
	locateTrashCan.
	
// Plan to pickup trash
+!clean(X,Y) : not carryingTrash <-
	.broadcast(achieve, forget(X,Y));
	moveTo(X,Y);
	pickupTrashAt(X,Y);
	if (not carryingTrash) {
		!findTrash
	}.

// Plan to forget a trash because another agent already cleaned it
+!forget(X,Y) <-
	.abolish(trash(X,Y)).

// Plan to dispose of trash
+!dispose : carryingTrash & trashCan(X,Y) <-
	moveTo(X,Y);
	disposeTrash;
	!findTrash.

// Plan to find trash
+!findTrash : trash(X,Y) <-
	!clean(X,Y).
+!findTrash : not trash(_,_) <-
	scanSurroundings;
	!findTrash.
