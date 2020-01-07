

# Liam Bigelow
# LiamDBigelow@gmail.com

class binaryTreeNode:
    """
    Class representing a tree node, will be built off of to create tree data structure
    """

    def __init__(self, value, left=None, right=None ):
        """
        initializes the Node with a value as well as sets the defaults
        for the left and right sub trees if nothing is given
        :param value: Value of node
        :param left: left subtree
        :param right: right subtree
        """

        self.value = value
        self.left = left
        self.right = right


    def setValue(self, newVal):
        """
        sets the value of the tree node to the specified val
        :param newVal: value that will replace
        :return: Nothing is returned
        """

        self.value = newVal

    def getValue(self):
        """
        Gets the value in the current node
        :return: the value of the node
        """

        return self.value

    def setLeft(self, leftTree ):
        """
        Sets the left subtree to a created subtree
        :param leftTree: the subtree that will be set on the left
        :return: Nothing is returned
        """

        self.left = leftTree

    def getLeft(self ):
        """
        Gets the treeNode at the left subtree
        :return: the treeNode representing the left subtree
        """

        return self.left

    def setRight(self, rightTree):
        """
        Sets the right subtree to a created subtree
        :param rightTree: the subtree that will be set on the right
        :return: Nothing is returned
        """

        self.right = rightTree

    def getRight(self):
        """
        Gets the treeNode at the right subtree
        :return: the treeNode representing the right subtree
        """

        return self.right
