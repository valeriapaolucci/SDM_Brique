package BriqueTest;

import org.junit.Test;
import org.junit.Assert;

public class IO_InterfaceTest {

    @Test
    public void testInput1() {
        String string = "b1";
        Assert.assertTrue(string.matches("[a-o0-9]+"));
    }

}