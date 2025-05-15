// File Name: Mylist_Activity.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices
package com.yvc.ex2_2025;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDate;
import java.util.ArrayList;

public class MyList_Activity extends AppCompatActivity {
    private ListView Takenbooks_lv;
    private ArrayList<Book> mybooks;
    private MyBooksAdapter newadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_list);

        Takenbooks_lv=findViewById(R.id.takenbook_list_view);
        mybooks = BrowseBooksActivity.mybooks;

        newadapter = new MyBooksAdapter(this, R.layout.book_item, mybooks);
        Takenbooks_lv.setAdapter(newadapter);

        for (Book book : mybooks) {
            if (book.getReturndate() != null && book.getReturndate().isBefore(LocalDate.now())) {
                Toast.makeText(this, "זמן ההגשה עבר עבור הספר: " + book.getName(), Toast.LENGTH_LONG).show();
            }
        }


        Button back_button = findViewById(R.id.back_to_browse_books);
        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(MyList_Activity.this, BrowseBooksActivity.class);
            startActivity(intent);
        });


    }



}