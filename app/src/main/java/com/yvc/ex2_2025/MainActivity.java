// File Name: MainActivity.java
// Students Name: Omer Gamliel | ID: 209052786
// Students Name: Batel Gofleyzer | ID: 211869409
// Course Name: 62187 Application Development for Smart Devices

package com.yvc.ex2_2025;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/*
 * This is the main activity of the application. It serves as the entry point for the user.
 * The user can navigate to two different activities: BrowseBooksActivity and MyList_Activity.
 */
public class MainActivity extends AppCompatActivity {
    Button BWbrowse; // Button to browse books
    Button BWmylist; // Button to my list

    // onCreate method is called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Set the content view to activity_main.xml

        // Find the buttons in the layout
        Button BWbrowse = findViewById(R.id.BWbrowse); // Button to browse books
        Button BWmylist = findViewById(R.id.BWmylist); // Button to my list

        // Set onClick listener for the browse books button
        BWbrowse.setOnClickListener(v -> {
            Intent intent = new Intent(this, BrowseBooksActivity.class); // Intent to browse books
            startActivity(intent); // Start the BrowseBooksActivity
        });

        // Set onClick listener for the my list button
        BWmylist.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyList_Activity.class); // Intent to my list
            startActivity(intent); // Start the MyList_Activity
        });
    };
}