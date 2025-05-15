// File Name: BookAdapter.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices

package com.yvc.ex2_2025;
import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * BookAdapter is a custom ArrayAdapter for displaying book items in a ListView
 * It binds the data from the Book model to the views in the book_item layout
 */
public class BookAdapter extends ArrayAdapter<Book> {
    private Context context; // Context
    private ArrayList<Book> books_list; // List of books to display

    // Constructor
    public BookAdapter(Context context, int resource, ArrayList<Book> books_list) {
        super(context, resource);
        this.context = context;
        this.books_list = books_list;
    }

    // Method to get the number of books in books_list
    @Override
    public int getCount() {
        return books_list.size(); // Return the number of books
    }

    // Method to get the position of a book in books_list
    @Override
    public Book getItem(int position) { // Get the position number of the book
        return books_list.get(position); // Return the book at this position
    }

    // Method getView to create and bind the view for each book item
    @Override
    public View getView(int position, View rootView, ViewGroup parent) {
        // If the rootView is null, create a new view
        if (rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(context); // Get the LayoutInflater
            rootView = inflater.inflate(R.layout.book_item, null, false); // Inflate the book_item layout
        }

        // Get the book item at the current position
        Book book = getItem(position);

        // Find the views in the book_item layout
        TextView name = rootView.findViewById(R.id.name); // Book name
        TextView author = rootView.findViewById(R.id.author); // Book author
        ImageView cover = rootView.findViewById(R.id.cover); // Book cover image
        Button addButton = rootView.findViewById(R.id.addButton); // Add button
        TextView url=rootView.findViewById(R.id.url); // Book url
        EditText returnDate = rootView.findViewById(R.id.returnDate); // Return date
        Button reminderButton = rootView.findViewById(R.id.reminderButton); // Reminder button

        // Set the visibility to GONE to hide the return date and reminder button in activity_browse_books layout
        returnDate.setVisibility(View.GONE);
        reminderButton.setVisibility(View.GONE);

        // Set the book url to be clickable
        url.setMovementMethod(LinkMovementMethod.getInstance());

        // Set the book details in the views
        if (book != null) {
            name.setText(book.getName());
            author.setText(book.getAuthor());
            cover.setImageResource(book.getCoverID());
            url.setText(book.getUrl());
        }

        // Set the click listener for the add button
        addButton.setOnClickListener(v -> {
            // Check if the book is already in the mybooks list
            if (BrowseBooksActivity.mybooks.contains(book)) { // if the book is already in the list
                Toast.makeText(context, "הספר כבר נוסף לרשימה שלך", Toast.LENGTH_SHORT).show(); // Show a toast message
            } else { // if the book is not in the list
                BrowseBooksActivity.mybooks.add(book); // Add the book to the mybooks list
                Intent intent = new Intent(context, MyList_Activity.class); // Create intent
                context.startActivity(intent); // Start MyList_Activity
            }
        });

        return rootView;
    }
}
