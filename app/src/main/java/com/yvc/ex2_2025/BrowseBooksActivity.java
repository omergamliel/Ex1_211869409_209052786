// File Name: BrowseBooksActivity.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices

package com.yvc.ex2_2025;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * This class represents the activity for browsing books.
 * It displays a list of books and allows the user to navigate back to their book list.
 */
public class BrowseBooksActivity extends Activity {
    private ListView book_list_view; // ListView to display the list of books
    private BookAdapter adapter; // Adapter for the ListView
    private ArrayList<Book> books; // ArrayList to hold the general list of books
    public static ArrayList<Book> mybooks = new ArrayList<>(); // ArrayList to hold my list books

    // onCreate method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books); // Set the content view to the activity_browse_books layout
        book_list_view = findViewById(R.id.book_list_view); // Initialize the ListView

        // Initialize the ArrayList of books
        books = new ArrayList<>();

        // Add books to the ArrayList
        books.add(new Book("Twilight", "Stephenie Meyer", R.drawable.twilight, "https://www.google.com/")); // BOOK 1
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", R.drawable.harrypotter, "https://www.google.com/")); // BOOK 2
        books.add(new Book("Dork Diaries", "Rachel Renée Russell", R.drawable.nerddiaries, "https://www.google.com/")); // BOOK 3
        books.add(new Book("Bridgerton: The Duke and I", "Julia Quinn", R.drawable.bridgerton, "https://www.google.com/")); // BOOK 4
        books.add(new Book("The Hunger Games", "Suzanne Collins", R.drawable.hungergames, "https://www.google.com/")); // BOOK 5
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", R.drawable.tokillamockingbird, "https://www.google.com/")); // BOOK 6
        books.add(new Book("1984", "George Orwell", R.drawable.nineteeneightyfour, "https://www.google.com/")); // BOOK 7
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", R.drawable.thegreatgatsby, "https://www.google.com/")); // BOOK 8
        books.add(new Book("Pride and Prejudice", "Jane Austen", R.drawable.prideandprejudice, "https://www.google.com/")); // BOOK 9
        books.add(new Book("The Maze Runner", "James Dashner", R.drawable.themazerunner, "https://www.google.com/")); // BOOK 10

        // Create an instance of the BookAdapter and set it to the ListView
        adapter = new BookAdapter(this, R.layout.book_item, books);
        book_list_view.setAdapter(adapter);

        // Set an item click listener for the ListView
        Button mylist_button = findViewById(R.id.back_to_mylist);
        mylist_button.setOnClickListener(v -> {
            Intent intent = new Intent(BrowseBooksActivity.this, MyList_Activity.class); // Create an intent to MyList_Activity
            startActivity(intent); // Start the MyList_Activity
        });
    }
}