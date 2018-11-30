package project5;

//import java.io.FileNotFoundException;

/**
 * the project runner.
 * 
 * @author Gengze Lyu
 * @version 2018.11.26
 */
public class GUIProjectRunner {

    /**
     * the main method calls other.
     * 
     * @param args
     *            input file names.
     * @throws SpaceColonyDataException
     */
    public static void main(String[] args) {
        GUIMusicPreference window = new GUIMusicPreference(args);
    }
}

