package eu.simmig.cauldron;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CauldronTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSetStyle() throws Exception {
        Cauldron cauldron = new Cauldron();
        int style = 1;
        cauldron.setStyle(style);
        assertEquals(style, cauldron.getStyle());
        exception.expect(IllegalArgumentException.class);
        style = -1;
        cauldron.setStyle(style);
    }

    @Test
    public void testSetBackgroundFinish() throws Exception {
        Cauldron cauldron = new Cauldron();
        int finish = 2;
        cauldron.setBackgroundFinish(finish);
        assertEquals(finish, cauldron.getBackgroundFinish());
        exception.expect(IllegalArgumentException.class);
        finish = 4;
        cauldron.setBackgroundFinish(finish);
    }

    @Test
    public void testSetSymbol() throws Exception {
        Cauldron cauldron = new Cauldron();
        int symbol = 3;
        cauldron.setSymbol(symbol);
        assertEquals(symbol, cauldron.getSymbol());
        exception.expect(IllegalArgumentException.class);
        symbol = -1;
        cauldron.setSymbol(symbol);
    }

    @Test
    public void testSetNumberOfSymbols() throws Exception {
        Cauldron cauldron = new Cauldron();
        int number = 1;
        cauldron.setBackgroundFinish(number);
        assertEquals(number, cauldron.getBackgroundFinish());
        number = 0;
        cauldron.setBackgroundFinish(number);
        assertEquals(number, cauldron.getBackgroundFinish());
        exception.expect(IllegalArgumentException.class);
        number = 41;
        cauldron.setBackgroundFinish(number);
    }

    @Test
    public void testOf() throws Exception {
        Cauldron cauldron = Cauldron.of("handle", "dots", "triangle", "1");
        assertEquals(3, cauldron.getStyle());
        assertEquals(2, cauldron.getBackgroundFinish());
        assertEquals(1, cauldron.getSymbol());
        assertEquals(1, cauldron.getNumberOfSymbols());
        exception.expect(IllegalArgumentException.class);
        cauldron = Cauldron.of("this", "test", "should", "fail");
    }

    @Test
    public void testFeatureAsString() throws Exception {
        Cauldron cauldron = Cauldron.of("plain", "stripes", "ellipse", "2");
        assertEquals("plain", Cauldron.featureAsString(Cauldron.STYLES, cauldron.getStyle()));
        assertEquals("stripes", Cauldron.featureAsString(Cauldron.FINISHES, cauldron.getBackgroundFinish()));
        assertEquals("ellipse", Cauldron.featureAsString(Cauldron.SYMBOLS, cauldron.getSymbol()));
        assertEquals("<unknown>", Cauldron.featureAsString(Cauldron.STYLES, 0));
        assertEquals("<unknown>", Cauldron.featureAsString(Cauldron.FINISHES, 4));
    }

    @Test
    public void testParseFeature() throws Exception {
        assertEquals(1, Cauldron.parseFeature(Cauldron.STYLES, "plain"));
        assertEquals(1, Cauldron.parseFeature(Cauldron.FINISHES, "dark"));
        assertEquals(2, Cauldron.parseFeature(Cauldron.SYMBOLS, "square"));
        assertEquals(0, Cauldron.parseFeature(Cauldron.STYLES, "fail"));
    }
}