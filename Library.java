package SingletonDesignPattern;

import java.util.HashMap;

/**
 * Class that represents a library. Library is implemented using a hashmap.
 * @author Seth Baugh
 */
public class Library {
    private HashMap<String, Integer> books = new HashMap<>();
    private static Library library;

    /**
     * Constructor that just lets the user know that the library has been created.
     */
    private Library() {
        System.out.println("Creating our Library. Time to begin reading");
    }

    /**
     * Method that returns the static variable library. Only one Library can be made
     * so if the method is called again it returns the same library already made.
     * @return library that is used in the driver class.
     */
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
            return library;
        }
        return library;
    }

    /**
     * Method that checks to see if the book exists in the hashMap and if it does it
     * checks to see if there is at least one copy of the book.
     * @return boolean true if the book is available and false if not available.
     * @param bookname name of the book to be searched for.
     */
    public boolean checkoutBook(String bookName) {
        if (books.containsKey(bookName) && books.get(bookName) > 0) {
            books.replace(bookName, books.get(bookName) - 1);
            System.out.println(bookName + " was successfully checked out.");
            return true;
        }
        System.out.println("Sorry, " + bookName + " was not in stock.");
        return false;
    }

    /**
     * Method that takes in two parameters and puts those parameters into the
     * hashMap. BookName variable is the key and numToAdd is the value. Increases
     * numOfCopies if book already exists. 
     * @param bookName name of the book to be searched for.
     * @param numToAdd number of copies to be added to the hashMap.
     */
    public void checkInBook(String bookName, int numToAdd) {
        if (books.containsKey(bookName)) {
            books.replace(bookName, books.get(bookName) + numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library.");
        }

        else {
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library.");
        }
    }

    /**
     * Method that loops and prints through all the names of the books and prints
     * the numOfCopies they have.
     */
    public void displayBooks() {
        System.out.println();
        System.out.println("Inventory: ");
        for (String key : books.keySet()) {
            System.out.println("-" + key + ", copies: " + books.get(key));
        }
    }
}
