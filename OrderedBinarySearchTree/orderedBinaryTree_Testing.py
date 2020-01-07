

# Liam Bigelow
# LiamDBigelow@gmail.com

# this python file will function as a testing suite for the Ordered Binary Tree
import orderedBinaryTree as OBTree

##### PERFORM UNIT TESTING ON DATA STRUCTURE #####

errorCount = 0

# Sets initial root as 5
test = OBTree.orderedBinaryTree( 5 )
if( test.root.getValue() != 5 ):
    print("ERROR: Initialization of value incorrect.")
    errorCount += 1


#### Testing Insert ####

test.insert( 3 )
test.insert( 1 )
test.insert( 4 )
test.insert( 6 )
test.insert( 7 )
test.insert( 9 )
test.insert( 8 )

if( test.root.getLeft().getValue() != 3 ):
    print("ERROR: Insertion of 3 incorrect.")
    errorCount += 1
if( test.root.getLeft().getLeft().getValue() != 1 ):
    print("ERROR: Insertion of 1 incorrect.")
    errorCount += 1
if( test.root.getLeft().getRight().getValue() != 4 ):
    print("ERROR: Insertion of 4 incorrect.")
    errorCount += 1
if( test.root.getRight().getValue() != 6 ):
    print("ERROR: Insertion of 6 incorrect.")
    errorCount += 1
if( test.root.getRight().getRight().getValue() != 7 ):
    print("ERROR: Insertion of 7 incorrect.")
    errorCount += 1
if( test.root.getRight().getRight().getRight().getValue() != 9 ):
    print("ERROR: Insertion of 9 incorrect.")
    errorCount += 1
if( test.root.getRight().getRight().getRight().getLeft().getValue() != 8 ):
    print("ERROR: Insertion of 8 incorrect.")
    errorCount += 1


#### Testing Contains ####

if( not test.contains( 3 ) ):
    print("ERROR: Contains returned incorrectly when value is in tree.")
    errorCount += 1
if( not test.contains( 6 ) ):
    print("ERROR: Contains returned incorrectly when value is in tree.")
    errorCount += 1
if( not test.contains( 9 ) ):
    print("ERROR: Contains returned incorrectly when value is in tree.")
    errorCount += 1
if( not test.contains( 5 ) ):
    print("ERROR: Contains returned incorrectly when value is in tree.")
    errorCount += 1
if( test.contains( 12 ) ):
    print("ERROR: Contains returned incorrectly when value is not in tree.")
    errorCount += 1
if( test.contains( 0 ) ):
    print("ERROR: Contains returned incorrectly when value is not in tree.")
    errorCount += 1

#### Testing Print #####
print( test )
########################

#### Testing Remove ####

test.remove( 6 )
if( test.root.getRight().getValue() != 7 ):
    print("ERROR: Deletion of 6 incorrect.")
    errorCount += 1
test.remove( 3 )
if( test.root.getLeft().getValue() != 4 ):
    print("ERROR: Deletion of 4 incorrect.")
    errorCount += 1
test.remove( 5 )
if( test.root.getValue() != 7 ):
    print("ERROR: Deletion of 5 incorrect. ( root )" )
    errorCount += 1
test.remove( 1 )
if( test.root.getLeft().getLeft() != None ):
    print("ERROR: Deletion of 1 incorrect." )
    errorCount += 1


#### Testing Print #####
print( test )
########################

test.remove( 7 )
test.remove( 4 )
test.remove( 9 )
if( test.root.getValue() != 8 and test.root.getLeft() == None and test.root.getRight() == None ):
    print("ERROR: Deletion of all but 1 node incorrect." )
    errorCount += 1

#### Testing Print #####
print( test )
########################

test.remove( 8 )
if( test.root != None ):
    print("ERRROR: Deletion of final node in tree incorrect.")
    errorCount += 1

#### Testing Print #####
print( test )
########################


#### Testing Completed ####
print( "Testing finished with " + str( errorCount ) + " error(s).")