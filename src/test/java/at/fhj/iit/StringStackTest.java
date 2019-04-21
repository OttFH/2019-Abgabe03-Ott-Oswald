package at.fhj.iit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringStackTest
{
    public Stack stack;
    
    @Before
    public void setup() throws Exception
    {
        stack = new StringStack(5); // keep size of 5 !!
    }
    
    /**
     * tests if stack is empty after initialization
     * 
     * use assert
     * - assertTrue to check it's empty
     */
    @Test
    public void testIsEmpty() throws Exception
    {
        Assert.assertTrue(stack.isEmpty());
    }
    
    /**
     * tests if stack is empty after pushing
     * 
     * use assert
     * - assertFalse to check it's not empty
     */
    @Test
    public void testIsNotEmpty() throws Exception
    {
        stack.push("");
        Assert.assertFalse(stack.isEmpty());
    }

    /**
     * tests push and pop function
     * 
     * do following test
     * - use push, 1 or x times
     * - use pull, as often as you use push
     * - use isEmpty to check that's empty again
     * - assert every content of the stack in the correct ordering
     * @throws Exception 
     */
    @Test
    public void testPushPop() throws Exception
    {
        stack.push("Zero");
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        Assert.assertEquals("Four",stack.pop());
        Assert.assertEquals("Three",stack.pop());
        Assert.assertEquals("Two",stack.pop());
        Assert.assertEquals("One",stack.pop());
        Assert.assertEquals("Zero",stack.pop());

        Assert.assertTrue(stack.isEmpty());
    }
    
    /**
     * Feel Free to insert other test cases for the String Stack Implementation !!!
     */

    /**
     * tests the size of stack. Pushing more than the actual size. Should give back Exception.
     */
    @Test(expected = IllegalStateException.class)
    public void testPushTooMuch() throws Exception
    {
        stack.push("Five");
        stack.push("Six");
        stack.push("Seven");
        stack.push("Eight");
        stack.push("Nine");
        stack.push("Ten");
    }

    @Test(expected = IllegalStateException.class)
    public void testPopToMuch() throws Exception
    {
        stack.push("Eleven");
        stack.push("Twelve");
        stack.push("Thirteen");

        Assert.assertEquals("Thirteen",stack.pop());
        Assert.assertEquals("Twelve",stack.pop());
        Assert.assertEquals("Eleven",stack.pop());

        Assert.assertTrue(stack.isEmpty());

        stack.pop();
    }
}