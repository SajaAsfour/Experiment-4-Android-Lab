package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout secondLinearLayout;
    EditText idInput;
    Button filterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout firstLinearLayout = new LinearLayout(this);
        Button addButton = new Button(this);
        secondLinearLayout = new LinearLayout(this);
        ScrollView scrollView = new ScrollView(this);

        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);

        addButton.setText("Add Customer");
        addButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

// Create an EditText to enter ID
        idInput = new EditText(this);
        idInput.setHint("Enter ID to filter");

// Create a Filter Button
        filterButton = new Button(this);
        filterButton.setText("Filter by ID");

// Add elements to layout
        firstLinearLayout.addView(addButton);
        firstLinearLayout.addView(idInput);
        firstLinearLayout.addView(filterButton);
        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);

        setContentView(firstLinearLayout);

// Open AddCustomerActivity when the "Add Customer" button is clicked
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCustomerActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

// Set Click Listener for Filter Button
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterById();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayAllCustomers();
    }

    private void displayAllCustomers() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, "EXP4", null, 1);
        Cursor allCustomerCursor = dataBaseHelper.getAllCustomers();
        secondLinearLayout.removeAllViews();

        while (allCustomerCursor.moveToNext()) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(
                    "Id= " + allCustomerCursor.getString(0)
                            + "\nName= " + allCustomerCursor.getString(1)
                            + "\nEmail= " + allCustomerCursor.getString(2)
                            + "\nPhone= " + allCustomerCursor.getString(3)
                            + "\nGender= " + allCustomerCursor.getString(4)
                            + "\n\n"
            );
            secondLinearLayout.addView(textView);
        }
        allCustomerCursor.close();
    }

    private void filterById() {
        String id = idInput.getText().toString().trim();
        if (id.isEmpty()) {
            displayAllCustomers(); // Show all if input is empty
            return;
        }

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, "EXP4", null, 1);
        Cursor cursor = dataBaseHelper.getCustomersById(id);

        secondLinearLayout.removeAllViews();

        if (cursor.moveToFirst()) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(
                    "Id= " + cursor.getString(0)
                            + "\nName= " + cursor.getString(1)
                            + "\nPhone= " + cursor.getString(2)
                            + "\nGender= " + cursor.getString(3)
                            + "\nEmail= " + cursor.getString(4)
                            + "\n\n"
            );
            secondLinearLayout.addView(textView);
        } else {
            TextView textView = new TextView(MainActivity.this);
            textView.setText("No customer found with ID " + id);
            secondLinearLayout.addView(textView);
        }
        cursor.close();
    }
}