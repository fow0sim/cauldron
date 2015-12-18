package eu.simmig.cauldron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CauldronGrid {
    ArrayList<Cauldron> cauldrons;
    int size;

    public CauldronGrid(int size, String filename) {
        this.size = size;
        loadFromFile(filename);
    }

    public void addCauldron(Cauldron cauldron) {
        if (cauldrons.size() == size) {
            throw new IllegalArgumentException();
        }
        cauldron.setGridIndex(cauldrons.size() + 1);
        cauldrons.add(cauldron);
    }

    public List<Cauldron> getCauldrons() {
        return cauldrons;
    }

    public int getSize() {
        return size;
    }

    public void loadFromFile(String filename) {
        int ix = 0;
        cauldrons = new ArrayList<Cauldron>(size);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                ix += 1;
                line = line.trim();
                if (line.length() > 0 && line.charAt(0) != '#') {
                    Cauldron cauldron = parseCauldron(line, ix);
                    if (cauldron != null) {
                        addCauldron(cauldron);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Cauldron parseCauldron(String line, int ix) {
        String delimiter = "[, ]+";
        String[] tokens = line.split(delimiter);
        if (tokens.length != 4) {
            System.out.println("Invalid line (" + ix + "): " + line);
            throw new IllegalArgumentException();
        }
        return Cauldron.of(tokens[0], tokens[1], tokens[2], tokens[3]);
    }

    public CauldronSolution solve() {
        CauldronSolution result = new CauldronSolution();
        CauldronTriplet triplet = new CauldronTriplet();
        for (int ix = 0; ix < cauldrons.size() - 2; ix += 1) {
            triplet.setCauldron(cauldrons.get(ix), 0);
            for (int jx = ix + 1; jx < cauldrons.size() - 1; jx += 1) {
                triplet.setCauldron(cauldrons.get(jx), 1);
                for (int kx = jx + 1; kx < cauldrons.size(); kx += 1) {
                    triplet.setCauldron(cauldrons.get(kx), 2);
                    result.incrementPermutations();
                    if (triplet.isCompliant()) {
                        result.addTriplet(triplet);
                        triplet = new CauldronTriplet(triplet);
                    }
                }
            }
        }
        return result;
    }

    public void print() {
        for (Cauldron cauldron : getCauldrons()) {
            System.out.println(cauldron);
        }
    }

}
