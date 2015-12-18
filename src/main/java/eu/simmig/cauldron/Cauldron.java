package eu.simmig.cauldron;

public class Cauldron {
    public static final String STYLES[] = { "plain", "lid", "handle" };
    public static final String FINISHES[] = { "dark", "dots", "stripes" };
    public static final String SYMBOLS[] = { "triangle", "square", "ellipse" };

    private int style;
    private int backgroundFinish;
    private int symbol;
    private int numberOfSymbols;
    private int gridIndex;

    public static Cauldron of(String style, String finish, String symbol, String numberOfSymbols) {
        int i1 = Cauldron.parseFeature(Cauldron.STYLES, style);
        int i2 = Cauldron.parseFeature(Cauldron.FINISHES, finish);
        int i3 = Cauldron.parseFeature(Cauldron.SYMBOLS, symbol);
        int i4 = Integer.parseInt(numberOfSymbols);
        return new Cauldron(i1, i2, i3, i4);
    }

    Cauldron () {
    }

    Cauldron(int style, int finish, int symbol, int numberOfSymbols) {
        setStyle(style);
        setBackgroundFinish(finish);
        setSymbol(symbol);
        setNumberOfSymbols(numberOfSymbols);
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        if (style < 0 || style > STYLES.length) {
            throw new IllegalArgumentException();
        }
        this.style = style;
    }

    public int getBackgroundFinish() {
        return backgroundFinish;
    }

    public void setBackgroundFinish(int backgroundFinish) {
        if (backgroundFinish < 0 || backgroundFinish > FINISHES.length) {
            throw new IllegalArgumentException();
        }
        this.backgroundFinish = backgroundFinish;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        if (symbol < 0 || symbol > SYMBOLS.length) {
            throw new IllegalArgumentException();
        }
        this.symbol = symbol;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        if (numberOfSymbols < 0 || numberOfSymbols > SYMBOLS.length) {
            throw new IllegalArgumentException();
        }
        this.numberOfSymbols = numberOfSymbols;
    }

    public int getGridIndex() {
        return gridIndex;
    }

    public void setGridIndex(int gridIndex) {
        this.gridIndex = gridIndex;
    }

    public String toString() {
        return "Cauldron " + getGridIndex() + ": " + featureAsString(STYLES, getStyle()) + ","
                + featureAsString(FINISHES, getBackgroundFinish()) + ","
                + featureAsString(SYMBOLS, getSymbol()) + ":" + getNumberOfSymbols();
    }

    public static String featureAsString(String[] feature, int ix) {
        if (ix > 0 && ix <= feature.length) {
            return feature[ix - 1];
        }
        return "<unknown>";
    }

    public static int parseFeature(String[] feature, String s) {
        for (int ix = 0; ix < feature.length; ix += 1) {
            if (s.toLowerCase().equals(feature[ix])) {
                return ix + 1;
            }
        }
        return 0;
    }
}
