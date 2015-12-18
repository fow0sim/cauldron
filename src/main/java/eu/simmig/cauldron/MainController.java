package eu.simmig.cauldron;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainController {
    Properties config;

    private void loadConfiguration() {
        config = new Properties();
        String configFileName = "cauldron.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
        if (inputStream != null) {
            try {
                config.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MainController instance = new MainController();
        instance.run(args);
    }

    public void run(String[] args) {
        loadConfiguration();
        String s = config.getProperty("eu.simmig.cauldron.size", "12");
        int size = Integer.parseInt(s);
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        System.out.println("Building cauldron grid (" + size + "): " + filename);
        if (filename != null && filename.length() != 0) {
            CauldronGrid grid = new CauldronGrid(size, filename);
            System.out.println("");
            grid.print();
            System.out.println("");
            CauldronSolution result = grid.solve();
            result.printSolutions();
        } else {
            System.out.println("No filename specified");
        }
    }

}
