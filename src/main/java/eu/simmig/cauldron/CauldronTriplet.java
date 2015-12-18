package eu.simmig.cauldron;

public class CauldronTriplet {
    private Cauldron cauldrons[] = new Cauldron[3];

    CauldronTriplet() {
    }

    CauldronTriplet(CauldronTriplet triplet) {
        setCauldron(triplet.getCauldron(0), 0);
        setCauldron(triplet.getCauldron(1), 1);
        setCauldron(triplet.getCauldron(2), 2);
    }

    CauldronTriplet(Cauldron c1, Cauldron c2, Cauldron c3) {
        setCauldron(c1, 0);
        setCauldron(c2, 1);
        setCauldron(c3, 2);
    }

    public void setCauldron(Cauldron cauldron, int ix) {
        if (ix < 0 || ix >= cauldrons.length) {
            throw new IllegalArgumentException();
        }
        this.cauldrons[ix] = cauldron;
    }

    public Cauldron getCauldron(int ix) {
        return this.cauldrons[ix];
    }

    public Cauldron[] getCauldrons() {
        return this.cauldrons;
    }

    public boolean isCompliant() {
        Cauldron c[] = getCauldrons();
        return allEqualOrAllDifferent(c[0].getStyle(), c[1].getStyle(), c[2].getStyle())
                && allEqualOrAllDifferent(c[0].getBackgroundFinish(), c[1].getBackgroundFinish(), c[2].getBackgroundFinish())
                && allEqualOrAllDifferent(c[0].getSymbol(), c[1].getSymbol(), c[2].getSymbol())
                && allEqualOrAllDifferent(c[0].getNumberOfSymbols(), c[1].getNumberOfSymbols(), c[2].getNumberOfSymbols());
    }

    public String toString() {
        return "Permutation <" + getCauldron(0).getGridIndex()
                + ", " + getCauldron(1).getGridIndex()
                + ", " + getCauldron(2).getGridIndex() + ">";
    }

    public void print() {
        System.out.println(this);
        System.out.print(" ");
        System.out.println(getCauldron(0));
        System.out.print(" ");
        System.out.println(getCauldron(1));
        System.out.print(" ");
        System.out.println(getCauldron(2));
    }

    public static boolean allEqualOrAllDifferent(int i1, int i2, int i3) {
        return (i1 == i2 && i1 == i3) || (i1 != i2 && i1 != i3 && i2 != i3);
    }

}
