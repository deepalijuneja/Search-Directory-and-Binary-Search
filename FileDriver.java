import java.io.IOException;

/**
 * Finally, driver for findfile class.
 * 
 * @author Deepali Juneja
 * @version 12 May 2020
 */
public class FileDriver {
    public static void main(String args[]) throws IOException {// try more directories so results are more efficient, even with these directories, it wasn't per-se very slowly but things can be more efficient.
        testFindFile(100, "fractions.txt", "C:\\Users");
        System.out.println();
        testFindFile(100, "longwords.txt", "C:\\Users");
        System.out.println();
        testFindFile(10, "README.txt", "C:\\Users");
        System.out.println();
        testFindFile(2, "Date.java", "C:\\Users");
        System.out.println();
        testFindFile(10, "Money.java", "C:\\Users");
    }

    /**
     * Tester code in regards to the FindFile class.
     * @param maxFiles  max # of files
     * @param targetFiles One looking for
     * @param path path of file
     * @throws IOException 
     */
    private static void testFindFile(int maxFiles, String targetFiles, String path) throws IOException {
        FindFile f = new FindFile(maxFiles);
        f.directorySearch(targetFiles, path);

        if (f.getCount() > 0) {
            System.out.println("The name of file is: \"" + targetFiles + "\" was found " + f.getCount() + " times(s)");
            System.out.println("\"" + targetFiles + "\" was found at these places: ");
            for (String files : f.getFiles()) {
                if (files != null) {
                    System.out.println(files);
                }
            }
        } else {
            System.out.println(
                    "Uh-oh! Something's wrong. Either you have picked the wrong name or try searching again");
        }
    }
}