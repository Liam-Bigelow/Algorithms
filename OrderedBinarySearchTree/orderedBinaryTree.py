

# Liam Bigelow
# LiamDBigelow@gmail.com

# this class will not be known to the user
import binaryTreeNode as tNode

class orderedBinaryTree:
    """
    Binary search tree modifiers class
    Note: dupicated values is not allowed
    """

    def __init__(self, root=None ):
        """
        initializes the tree and may set the root value if a value is given
        :param root: the value that will be placed in the root of the tree
        """
        if( root == None ):
            # the tree is not be initialized only instantiated
            self.root = None
        else:
            # the tree is being initialized and instantiated
            self.root = tNode.binaryTreeNode(root)



    def insert(self, val ):
        """
        Creates a node for the given value and inserts
        it into the ordered binary tree

        :param val: the value that will be stored in the node
        :return: Nothing is returned
        """

        # need to make sure the value is not already contained
        if( self.contains( val ) ):
            raise Exception("Value is already contained in tree")

        # Initialize a new node with the specified variable
        newNode = tNode.binaryTreeNode(val)

        # Now need to find where to insert the value
        if( self.root == None ):
            self.root = newNode
        else:
            # will need to find the spot to drop the value
            cur = self.root
            while( cur != None ):
                # left is less then cur, right is greater then cur
                if( val < cur.getValue() ):
                    if( cur.getLeft() == None ):
                        cur.setLeft( newNode )
                        break
                    cur = cur.getLeft()
                else:
                    # must be greater
                    if( cur.getRight() == None ):
                        cur.setRight( newNode )
                        break
                    cur = cur.getRight()

        # process finished


    def remove(self, val, tRoot=None ):
        """
        This will remove the specified value from the binary tree through recursion

        :param val: the value that is being searched for
        :param tRoot: this does not need to be given for execution but is needed for recursion
        :return: current tree is returned but not needed for user since object is updated
        """

        # allows for a bit more abstraction by using a default since the root does not
        # need to be specified by the user but needs to change for recursive step in Case3
        if( tRoot == None ):
            cur = self.root
        else:
            cur = tRoot

        # Base Case: reached bottom of tree, terminate recursion
        if cur is None:
            return cur

        # Traversal to find where the value is located in the tree, Since the tree is Ordered Binary
        # property of left is smaller and right is larger holds
        if ( val < cur.getValue() ):
            cur.setLeft( self.remove( val, cur.getLeft() ) )
        elif ( val > cur.getValue() ):
            cur.setRight( self.remove( val, cur.getRight() ) )
        else:
            # Since The node is not larger or smaller or None it must be the searched for node can now delete

            # Case 1: there is only 1 or no children to the current
            # We can simply remove the joining node since there is no siblings to account for
            if( cur.getLeft() == None ):
                new = cur.getRight()
                cur = None
                self.root = cur # Update root encase no recursion
                return new
            elif( cur.getRight() == None ):
                new = cur.getLeft()
                cur = None
                self.root = cur # Update root encase no recursion
                return new

            # this will find the minimum value on the right subtree, or the inorder succesor of cur
            minNode = cur.getRight()
            while( minNode.getLeft() != None ):
                minNode = minNode.getLeft()

            # Set the min node contents and remove the node
            cur.setValue( minNode.getValue() )
            cur.setRight( self.remove( minNode.getValue() , cur.getRight() ) )

        self.root = cur
        return cur

        # Process Finished


    def contains(self, val ):
        """
        Checks whether a value is already contained in a tree
        :param val: the value that is being checked for
        :return: true if value is found, false otherwise
        """

        cur = self.root

        while (cur != None):
            # check if the value is found
            if( cur.getValue() == val ):
                return True

            # left is less then cur, right is greater then cur
            if (val < cur.getValue()):
                cur = cur.getLeft()
            else:
                cur = cur.getRight()

        # searched path in tree and nothing was found
        return False


    def __str__(self, tRoot=None, depth=0 ):
        """
        Builds a string representation of the binary tree
        :param tRoot: allows for easier recursion and is abstracted from the user
        :param depth: represents the current depth of recursive steps to help with formatting
        :return: the completed string representation
        """

        # allows for a bit more abstraction by using a default since the root does not
        # need to be specified by the user but needs to change for recursive step in Case3
        if( tRoot == None ):
            cur = self.root
        else:
            cur = tRoot

        string = ""     # Decleration encase tree is empty

        if( cur != None ):

            string += "\t" * depth + str( cur.getValue() ) + "\n"

            # Recurse through childeren to build string
            if( cur.getLeft() != None ):
                string += self.__str__( cur.getLeft(), depth +1 )
            if( cur.getRight() != None ):
                string += self.__str__( cur.getRight(), depth +1 )

        return string



