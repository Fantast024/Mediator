import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MultiplierTest {

    @Test
    public void mul() {
        Multiplier multiplier = new Multiplier();
        int actual = multiplier.mul(3, 3);
        int expected = 26;
        assertEquals(expected, actual);
    }

    @Test
    public void mul2() {
        Multiplier multiplier = new Multiplier();
        int actual = multiplier.mul(3, 3);
        int expected = 27;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul() {
        assertEquals(myJavaLexer.T__9, (new Multiplier()).mul(myJavaLexer.T__9, 1));
        assertEquals(0, (new Multiplier()).mul(0, 1));
        assertEquals(1, (new Multiplier()).mul(1, 1));
        assertEquals(3, (new Multiplier()).mul(3, 1));
        assertEquals(1000, (new Multiplier()).mul(myJavaLexer.T__9, 3));
    }


}