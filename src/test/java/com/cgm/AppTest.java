package com.cgm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testFoo() {

        Foo foo = new Foo();
        String fooBar = foo.getFooBar();
        assertEquals("fooBar", fooBar);


        
    }

    @Test
    public void testName() {
        
    }

    

    
}
