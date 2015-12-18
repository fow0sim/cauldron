package eu.simmig.cauldron;

import java.util.ArrayList;

public class CauldronSolution {
    private ArrayList<CauldronTriplet> triplets = new ArrayList<CauldronTriplet>();
    private int permutations = 0;

    public ArrayList<CauldronTriplet> getTriplets() {
        return triplets;
    }

    public void addTriplet(CauldronTriplet triplet) {
        this.triplets.add(triplet);
    }

    public int getSolutions() {
        return triplets.size();
    }

    public int getPermutations() {
        return permutations;
    }

    public void setPermutations(int permutations) {
        this.permutations = permutations;
    }

    public void incrementPermutations() {
        setPermutations(getPermutations() + 1);
    }

    public void printSolutions() {
        for (CauldronTriplet triplet : getTriplets()) {
            triplet.print();
            System.out.println("");
        }
        System.out.println(getPermutations() + " permutations tested.");
    }
}
