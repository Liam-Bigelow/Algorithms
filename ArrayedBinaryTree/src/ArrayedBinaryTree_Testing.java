
/*
Liam Bigelow
LiamDBigelow@gmail.com
 */


public class ArrayedBinaryTree_Testing {

    public static int ArrayedBinarTreeTestSuite(){
        int failedTests = 0;

        ArrayedBinaryTree testTree = new ArrayedBinaryTree<Integer>();

        // ########### test root functionality ###########
        try{
            testTree.getRoot();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected do nothing.
        }
        testTree.setRoot( 1 );
        if( ! testTree.getRoot().equals( 1 ) ){
            failedTests++;
        }
        testTree.goRoot();
        if( ! testTree.getValue().equals( 1 ) ){
            failedTests++;
        }
        testTree.setValue( 2 );
        if( ! testTree.getRoot().equals( 2 ) ){
            failedTests++;
        }


        // ########### test left sub tree functionality
        try{
            testTree.getLeft();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected do nothing.
        }
        testTree.setLeft( 6 );
        if( ! testTree.getLeft().equals( 6 ) ){
            failedTests++;
        }
        testTree.goLeft();
        if( ! testTree.getValue().equals( 6 ) ){
            failedTests++;
        }
        testTree.setLeft( 8 );
        if( ! testTree.getLeft().equals( 8 ) ){
            failedTests++;
        }
        testTree.goBack();
        if( ! testTree.getValue().equals(2) ){
            failedTests++;
        }
        testTree.removeLeft();
        try{
            testTree.getLeft();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected, do nothing
        }


        // ########### test right sub tree functionality
        try{
            testTree.getRight();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected do nothing.
        }
        testTree.setRight( 6 );
        if( ! testTree.getRight().equals( 6 ) ){
            failedTests++;
        }
        testTree.goRight();
        if( ! testTree.getValue().equals( 6 ) ){
            failedTests++;
        }
        testTree.setRight( 8 );
        if( ! testTree.getRight().equals( 8 ) ){
            failedTests++;
        }
        testTree.goBack();
        if( ! testTree.getValue().equals(2) ){
            failedTests++;
        }
        testTree.removeRight();
        try{
            testTree.getRight();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected, do nothing
        }



        // ########### test right and left sub tree functionality together
        testTree.setRight( 6 );
        testTree.setLeft( 1 );
        if( ! testTree.getLeft().equals( 1 ) ){
            failedTests++;
        }
        if( ! testTree.getRight().equals( 6 ) ){
            failedTests++;
        }
        testTree.goLeft();
        testTree.setRight( 8 );
        testTree.setLeft( 3 );
        if( ! testTree.getLeft().equals( 3 ) ){
            failedTests++;
        }
        if( ! testTree.getRight().equals( 8 ) ){
            failedTests++;
        }

        // Quick test of print
        System.out.println( testTree.toString() );

        testTree.goRoot();
        testTree.removeRoot();
        try {
            testTree.getRoot();
            failedTests++;
            testTree.getLeft();
            failedTests++;
            testTree.getRight();
            failedTests++;
        } catch ( IndexOutOfBoundsException e ){
            // Expected, do nothing
        }

        // Quick test of print
        System.out.println( testTree.toString() );

        return failedTests;
    }



    public static void main( String[] args ){

        // Run testing function
        System.out.println( "\nTesting finished with " + ArrayedBinarTreeTestSuite() + " error(s)." );
    }
}
