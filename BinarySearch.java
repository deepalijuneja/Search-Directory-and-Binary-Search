/**
 * This is another major class of the homework and it uses binary search to return the index of a word.
 * 
 * @author Deepali Juneja
 * @version 10 May 2020
 */
public class BinarySearch extends SearchAlgorithm {
    /**
     * Below is the iterative binary search.
     *
     * @param searchWord 
     * @param findWord
     * @return element's index
     * @throws ItemNotFoundException 
     */
    @Override
    public int search(String[] searchWord, String wordToFind) throws ItemNotFoundException {
        int lhs_index = 0;
        int rhs_index = searchWord.length - 1;
        while (lhs_index <= rhs_index) {
            int middle = (lhs_index + rhs_index) >>> 1;
            incrementCount();

            if (searchWord[middle].equals(wordToFind)) {
                return middle;
            }
            if (searchWord[middle].compareTo(wordToFind) > 0) {
                rhs_index = middle - 1;
            }
            else if (searchWord[middle].compareTo(wordToFind) < 0) {
                lhs_index = middle + 1;
            }
        }
        throw new ItemNotFoundException();
    }
    
    /**
     * Below is the recursive binary search method.
     *
     * @param searchWord .
     * @param findWord
     * @return item's index
     * @throws ItemNotFoundException 
     */
    @Override
    public int recSearch(String[] searchWord, String wordToFind) throws ItemNotFoundException {
        return recSearch(searchWord, wordToFind, 0, searchWord.length);
    }
    
    /**
     * Below is the helper method which recursively searches.
     *
     * @param searchWord 
     * @param findWord
     * @param lhs 
     * @param rhs 
     * @return item's index
     * @throws ItemNotFoundException 
     */
    private int recSearch(String[] searchWord, String wordToFind, int lhs, int rhs) throws ItemNotFoundException {
         if (lhs > rhs) {
            throw new ItemNotFoundException();
        }
        int middle = (lhs + rhs) >>> 1;
        incrementCount();
        return searchWord[middle].compareTo(wordToFind) < 0 ? recSearch(searchWord, wordToFind, middle + 1, rhs) :
               searchWord[middle].compareTo(wordToFind) > 0 ? recSearch(searchWord, wordToFind, lhs, middle - 1) : middle;
    }
}