import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class myBinarySearchTreeNodeTester {
    /*
sizeTest(): Given an array of 5 elements that is then turned into a binary search tree we will
test to see if the size() method in the myBinarySearchTreeNode class works and returns size:5

    test input = {3,0,1,4,5};
    expected output = 5;

    */
    @Test
    public void sizeTest(){//Passed
        int[] input = {3,0,1,4,5};//size: 5
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(input);
        assertEquals(5, test.size());
    }

    /*
depthTest(): Given an array that is then turned into a binary search tree we will
test to see if the depth() method in the myBinarySearchTreeNode class works by
searching for the value 5 and returns depth:2

    test input = {3,0,1,4,5};
    search = 5;
    expected output = 2;

    */
    @Test
    public void depthTest(){//Passed
        int[] input = {3,0,1,4,5};//search = 5 and expected depth is 2
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(input);
        assertEquals(2,test.depth(5));
    }

    /*
heightTest(): Given an array that is then turned into a binary search tree we will
test to see if the height() method in the myBinarySearchTreeNode class works by giving
the method the tree and returning the height of the tallest subtree which would be the
right for input[] with the height of 4

    test input = {3,0,1,4,5,7,2,9};
    expected output = 4;

    */
    @Test
    public void heightTest(){//Passed
        int[] input = {3,0,1,4,5,7,2,9};//expected height is 4 subtree right
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(input);
        assertEquals(4,test.height());
    }

    /*
insertTest(): Given an array that is then turned into a binary search tree we will
test to see if the insert() method in the myBinarySearchTreeNode class works by giving
the method the value 10 which should be the last node in the right subtree if inserted
right. The insert would be tested by finding the depth of the new inserted value which
would be 5 if inserted right.

    test input = {3,0,1,4,5,7,2,9};
    expected output = {3,0,1,4,5,7,2,9,10};

    */
    @Test
    public void insertTest(){//Passed
        int[] input = {3,0,1,4,5,7,2,9};//insert 10 on right subtree
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(input);
        test.insert(10);//inserted value should be found at depth 5 on the right subtree if inserted correctly
        assertEquals(5,test.depth(10));
    }

    /*
duplicateTest(): Given an array that is then turned into a binary search tree we will
test to see if the insert() method in the myBinarySearchTreeNode class works by giving
the method the value 9 which should not be inserted in any subtree ,because the value
already exists in the binary tree. This will be tested by comparing the input array
with the original/expected array to see there were any insertions occurring.

   test input = {3,0,1,4,5,7,2,9};
   expected output = {3,0,1,4,5,7,2,9,10};

   */
    @Test
    public void duplicateTest(){//Passed
        int[] input = {3,0,1,4,5,7,2,9};//insert 9 on right subtree
        int[] expected = {3,0,1,4,5,7,2,9};//array should remain the as input[]
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(input);
        test.insert(9);//inserted value should be disregarded and give an error message because inValue already exists in the tree
        assertArrayEquals(expected,input);//should have the same array before inserted
    }
}
