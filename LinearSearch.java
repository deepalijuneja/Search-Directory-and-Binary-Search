/**
 * This is one of the major classes of the Recursion HW which uses the linear method to look for words.
 * 
 * @author Deepali Juneja
 * @verion 10 May 2020
 */
public class LinearSearch extends SearchAlgorithm {
    /**
     *Below is the recursive search method.
     *
     * @param searchWord The words we are searching through
     * @param findWord   The word we are trying to find
     * @return item's index
     * @throws ItemNotFoundException 
     */
    @Override
    public int search(String[] searchWord, String findWord) throws ItemNotFoundException {
        int index = 0;
        for (incrementCount(); index < searchWord.length && !(searchWord[index].equalsIgnoreCase(findWord)); incrementCount(), index++);
        if (index < searchWord.length) {
            return index;
        }
        throw new ItemNotFoundException();
    }
    
    /**
     * Below is the recursive linear search method
     *
     * @param searchWord The words we are searching through
     * @param findWord The word we are trying to find
     * @return item's index
     * @throws ItemNotFoundException 
     */
    @Override
    public int recSearch(String[] searchWord, String findWord) throws ItemNotFoundException {
        return recSearch(searchWord, findWord, 0);
    }
    
    /**
     * Below is the helper method for the recursive method.
     *
     * @param searchWord The words we are searching through
     * @param findWord   The word we are trying to find
     * @param index 
     * @return item's index
     * @throws ItemNotFoundException 
     */
    private int recSearch(String[] searchWord, String findWord, int index) throws ItemNotFoundException {
        
        if (index >= searchWord.length) {
            throw new ItemNotFoundException();
        }
        incrementCount();
        
        if (searchWord[index].equalsIgnoreCase(findWord)) {
            return index;
        }
        return recSearch(searchWord, findWord, index + 1);
    }
}