import java.io.*;

/**
 * FindFile tries to find the number of time a file is present.
 * 
 * @author Deepali Juneja
 * @version 11 May 2020
 */
public class FindFile {

    private int maxFiles;// variables as provided in the assignment
    private int count = 0;
    private String[] FilePath;

    /**
     * 
     * Below is the empty constuctor.
     */
    public FindFile() {
        this.setMaxFiles(1);
        this.setFiles();
    }

    /**
     * 
     * Below is the full constructor of the class. 
     * 
     * @param maxFiles the max number of files.
     */
    public FindFile(int maxFiles) {
        this.setMaxFiles(maxFiles);
        this.setFiles();
    }

    /**
     * Below directory search occurs through recursive method.
     * 
     * @param targetFile 
     * @param location
     * @throws IOException 
     */
    public void directorySearch(String targetFile, String location) throws IOException {
        if (!targetFile.isEmpty() && !location.isEmpty()) {
            File newFile = new File(location);
            String[] fileList = newFile.list();
            if (fileList != null) {
                for (String file : fileList) {
                    String path = location + "\\" + file;
                    File tempFile = new File(path);
                    if (tempFile.isDirectory()) {
                        directorySearch(targetFile, path);
                    }
                    if (file.equals(targetFile)) {
                        FilePath[this.getCount()] = newFile.getAbsolutePath();
                                                                              
                        this.setCount(this.getCount() + 1);
                    }
                    if (this.getCount() > this.getMaxFiles()) {
                        throw new IllegalArgumentException("Max limit has been reached!");
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Sorry,empty targetfile!");
        }
    }

    /**
     * Getter for MaxFiles
     * 
     * @return
     */
    public int getMaxFiles() {
        int valueMaxFiles = this.maxFiles;
        return valueMaxFiles;
    }

    /**
     * Setter for MaxFiles.
     * 
     * @param maxFiles

     */
    private void setMaxFiles(int maxFiles) {
        if (maxFiles > 0) {
            this.maxFiles = maxFiles;
        } else {
            throw new IllegalArgumentException("Files need to be greater than 0");
        }
    }

    /**
     * Below method returns file path.
     * 
     * @return file paths' array
     */
    public String[] getFiles() {
        String[] valueFiles = new String[FilePath.length];
        int i = 0;
        for (String file : this.FilePath) {
            valueFiles[i] = file;
            i++;
        }
        return valueFiles;
    }

    /**
     * Setter for files to max no.
     */
    private void setFiles() {
        this.FilePath = new String[this.getMaxFiles()];
    }

    /**
     * Getter for counting files.
     * 
     * @return # of occurences
     */
    public int getCount() {
        int valueCount = this.count;
        return valueCount;
    }

    /**
     * Evaluates that count is valid.
     * 
     * @param count
     */
    private void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("Files need to be more than 0.");
        }
    }
}