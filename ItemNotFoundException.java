/**
 * Subclass of the parent Exception class.
 * 
 * @author Deepali Juneja
 * @version 10 May 2020
 */
public class ItemNotFoundException extends Exception {
    /**
     * Below is the first, empty constructor
     */ 
    public ItemNotFoundException() {
        super("Sorry, item not found!");
    }

    /**
     * The second, last constructor which prints the user message.
     * 
     * @param message  The message the user gives to produce
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}