// File Name: MyBooksAdapter.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices

package com.yvc.ex2_2025;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * MyBooksAdapter is a custom ArrayAdapter for displaying a list of books.
 * It extends the ArrayAdapter class and provides a way to bind book data to views.
 */
public class MyBooksAdapter extends ArrayAdapter<Book> {
    private Context context; // Context
    private ArrayList<Book> books_list; // List of books to be displayed

    // Constructor
    public MyBooksAdapter(Context context, int resource, ArrayList<Book> books_list) {
        super(context, resource);
        this.context = context;
        this.books_list = books_list;
    }

    // Method to get the count of books in book_list
    @Override
    public int getCount() {
        return books_list.size();
    }

    // Method to get the book at a specific position
    @Override
    public Book getItem(int position) {
        return books_list.get(position);
    }

    // Method getView to create and bind the view for each book item
    @Override
    public View getView(int position, View rootView, ViewGroup parent) {
        // Check if the rootView is null, if so, inflate a new view
        if (rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(context); // Inflate
            rootView = inflater.inflate(R.layout.book_item, null, false);
        }

        // Find the views in layout
        Book book = getItem(position);
        TextView name = rootView.findViewById(R.id.name);
        TextView author = rootView.findViewById(R.id.author);
        EditText returnDate = rootView.findViewById(R.id.returnDate);
        Button reminderButton = rootView.findViewById(R.id.reminderButton);
        ImageView cover = rootView.findViewById(R.id.cover);
        Button addButton = rootView.findViewById(R.id.addButton);
        TextView url=rootView.findViewById(R.id.url);

        // Set the visibility of views
        cover.setVisibility(View.GONE);
        addButton.setVisibility(View.GONE);
        url.setVisibility(View.GONE);

        // Set the book details in the views
        if (book != null) { // Check if book is not null
            name.setText(book.getName());  // Set book name
            author.setText(book.getAuthor()); // Set author name
            if (book.getReturndate() != null) { // Check if return date is not null
                returnDate.setText(book.getReturndate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // Format date
            } else { // If return date is null
                returnDate.setText(""); // Set a blank date (as string)
            }

            // Set the click listener for returnDate
            returnDate.setOnClickListener(v -> {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                android.app.DatePickerDialog datePickerDialog = new android.app.DatePickerDialog(context,
                        (view, year, month, dayOfMonth) -> { // DatePickerDialog listener
                            LocalDate selectedDate = LocalDate.of(year, month + 1, dayOfMonth); // Create LocalDate
                            String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Format date
                            returnDate.setText(formattedDate);
                        },
                        calendar.get(java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH));
                datePickerDialog.show(); // Show the DatePickerDialog
            });

            // Set the click listener for reminderButton
            reminderButton.setOnClickListener(v -> {
                String dateText = returnDate.getText().toString().trim(); // Get the date text
                if (!dateText.isEmpty()) { // Check if dateText is not empty
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // Create a DateTimeFormatter
                    LocalDate parsedDate = LocalDate.parse(dateText, formatter); // Parse the date
                    book.setReturndate(parsedDate); // Set the return date
                    Toast.makeText(context, "התזכורת הוגדרה", Toast.LENGTH_SHORT).show(); // Show success message
                } else { // If dateText is empty
                    Toast.makeText(context, "יש לבחור תאריך החזרה", Toast.LENGTH_SHORT).show(); // Show alert message
                }
            });
        }
        return rootView;
    }
}