package eu.simmig.cauldron;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CauldronTripletTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSetAndGetCauldron() throws Exception {
        CauldronTriplet triplet = new CauldronTriplet();
        Cauldron c1 = Cauldron.of("lid", "dots", "ellipse", "1");
        triplet.setCauldron(c1, 2);
        Cauldron c2 = triplet.getCauldron(2);
        assertEquals(c1, c2);
        exception.expect(IllegalArgumentException.class);
        triplet.setCauldron(c1, 3);
        exception.expect(IndexOutOfBoundsException.class);
        triplet.getCauldron(3);
    }

    @Test
    public void testIsCompliant() throws Exception {
        Cauldron c1 = Cauldron.of("plain", "dots", "square", "2");
        Cauldron c2 = Cauldron.of("handle", "dots", "triangle", "3");
        Cauldron c3 = Cauldron.of("lid", "dots", "ellipse", "1");
        CauldronTriplet triplet = new CauldronTriplet(c1, c2, c3);
        assertTrue(triplet.isCompliant());
        c3.setBackgroundFinish(Cauldron.parseFeature(Cauldron.FINISHES, "stripes"));
        assertFalse(triplet.isCompliant());
    }

    @Test
    public void testAllEqualOrAllDifferent() throws Exception {
        assertTrue(CauldronTriplet.allEqualOrAllDifferent(1, 1, 1));
        assertTrue(CauldronTriplet.allEqualOrAllDifferent(1, 2, 3));
        assertFalse(CauldronTriplet.allEqualOrAllDifferent(1, 2, 1));
    }
}