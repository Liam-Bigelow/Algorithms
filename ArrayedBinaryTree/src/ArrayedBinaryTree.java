
/*
Liam Bigelow
LiamDBigelow@gmail.com
 */

import java.util.ArrayList;

/**
 * Array implementation of a Binary tree
 * @param <E> uses a generic type for objects in tree
 */
public class ArrayedBinaryTree<E> {

    // Will be set in constructor containers of data structure as well as positions
    private ArrayList tree;
    private int position;
    private int size;

    /**
     * Constructor method, will setup array and defaults
     */
    public ArrayedBinaryTree(){
        this.tree = new ArrayList<E>();
        this.position = 0;
        this.size = 0;
    }

    /**
     * Sets the left node of the current node
     * Will create a new node if one does not currently exist
     * @param val value that will become left node
     */
    public void setLeft( E val ){
        int leftPos = ( this.position*2 ) +1;

        if( this.position == 0 ){
            leftPos = 1;
        }

        // Make sure that the list is large enough to account for a left child
        extendList( leftPos );

        // Set left child
        this.tree.set( leftPos, val );
    }

    /**
     * Gets the left node of the current node
     * @return the left node of current node
     */
    public Object getLeft(){
        int leftPos = ( this.position*2 ) +1;

        if( leftPos > this.size || this.tree.get(leftPos) == null ){
            throw new IndexOutOfBoundsException("A left node does not exist yet.");
        }
        // get left child
        return this.tree.get( leftPos );
    }

    /**
     * this will recursively delete the left subtree of a graph
     */
    public void removeLeft(){

        int leftPos = (this.position*2) +1;

        // will need to first clear left child
        if( leftPos < this.size ){
            this.tree.set( leftPos, null );
        }

        // then will need to delete branching children of left child
        leftPos = ( leftPos*2 ) +1;
        while( leftPos < this.size ){
            this.tree.set( leftPos, null ); // remove left child
            this.tree.set( leftPos +1, null ); // remove right child
            leftPos = (leftPos*2 ) +1;
        }
    }

    /**
     * Sets the right node of the current node
     * Will create a new node if one does not currently exist
     * @param val value that will become right node
     */
    public void setRight( E val ){
        int rightPos = ( this.position*2 ) +2;

        // Make sure that the list is large enough to account for a right child
        extendList( rightPos );

        // Set right child
        this.tree.set( rightPos, val );
    }

    /**
     * Gets the right node of the current node
     * @return the right node of current node
     */
    public Object getRight(){
        int rightPos = ( this.position*2 ) +2;

        if( rightPos > this.size || this.tree.get(rightPos) == null ){
            throw new IndexOutOfBoundsException("A right node does not exist yet.");
        }
        // get right child
        return this.tree.get( rightPos );
    }

    /**
     * this will recursively delete the right subtree of a graph
     */
    public void removeRight(){

        int rightPos = (this.position*2) +2;

        // will need to first clear right child
        if( rightPos < this.size ){
            this.tree.set( rightPos, null );
        }

        // then will need to delete branching children of right child
        rightPos = ( rightPos*2 ) +2;
        while( rightPos < this.size ){
            this.tree.set( rightPos, null ); // remove left child
            this.tree.set( rightPos -1, null ); // remove right child
            rightPos = (rightPos*2 ) +2;
        }
    }

    /**
     * this will set the value of the node that the cursor
     * is currently pointing to, to the specified value
     * @param val value that is being used
     */
    public void setValue( E val ){
        this.tree.set( this.position, val );
    }

    /**
     * returns the value of the node the cursor
     * is pointing at
     * @return the value of node cursor is set to
     */
    public Object getValue(){
        return this.tree.get( this.position );
    }

    /**
     * Will set the value of the root node
     * @param val the value that will become the root
     */
    public void setRoot( E val ){
        extendList( 1 );
        this.tree.set( 0, val );
    }

    /**
     * Will return the root element of the tree
     * @return the root element
     * @throws IndexOutOfBoundsException if root element is not set
     */
    public Object getRoot() throws IndexOutOfBoundsException {

        if( this.size <= 0 ){
            throw new IndexOutOfBoundsException("Root is not set yet");
        }

        return this.tree.get( 0 );
    }

    /**
     * by removing root you are erasing entire tree and
     * resetting to default values
     */
    public void removeRoot(){
        this.tree.clear();
        this.size = 0;
        this.position = 0;
    }

    /**
     * Will extend the list if the desired index is greater then the current
     * size of the list
     * @param desiredSize the desired index
     * @return true if list was extended, false otherwise
     */
    private boolean extendList( int desiredSize ){

        if( desiredSize == 1 && desiredSize > this.size ){
            this.tree.add( null );
            this.size = 1;
            return true;
        }
        else if( desiredSize +1 > this.size ){
            // Array needs to increase in size by 2^depth
            int newSize = (int) Math.pow(2, Math.log( size )+1 );

            for( int s = this.size; s <= newSize; s++ ){
                // Simply increasing Array size, null is used as place holder of empty
                this.tree.add( null );
            }

            this.size = this.tree.size();
            return true;
        }

        // No need to extend list to access desired position
        return false;
    }

    /**
     * moves the cursor down the left sub tree
     * @throws IndexOutOfBoundsException Can't go to a node that does not yet exist
     */
    public void goLeft(){

        int leftPos = ( this.position*2 ) +1;

        if( leftPos > this.size || this.tree.get(leftPos) == null ){
            throw new IndexOutOfBoundsException("A left node does not yet exist.");
        }

        // must exist, move to left node
        this.position = leftPos;
    }

    /**
     * moves the cursor down the right sub tree
     * @throws IndexOutOfBoundsException Can't go to a node that does not yet exist
     */
    public void goRight(){

        int rightPos = ( this.position*2 ) +2;

        if( rightPos > this.size || this.tree.get(rightPos) == null ){
            throw new IndexOutOfBoundsException("A right node does not yet exist.");
        }

        // must exist, move to right node
        this.position = rightPos;
    }

    /**
     * Moves the cursor to the parent node
     * @throws IndexOutOfBoundsException if the cursor is on the root can't go to parent
     */
    public void goBack(){

        int parent = (this.position -1) /2;

        if( parent < 0 ){
            throw new IndexOutOfBoundsException("There does not exist a parent to the root node");
        }

        // Parent exists, move cursor to parent position
        this.position = parent;
    }

    /**
     * moves the cursor to the root position
     */
    public void goRoot(){
        // move to 0 position of array
        this.position = 0;
    }

    /**
     * Returns the tree array as a string
     * @return a string representation of tree
     */
    @Override
    public String toString() {
        return this.tree.toString();
    }
}
