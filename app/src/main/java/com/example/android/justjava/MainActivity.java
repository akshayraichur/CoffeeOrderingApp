package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox WhippedCreamCheckedBox = (CheckBox) findViewById(R.id.checkbox);
        boolean hasWhippedCream = WhippedCreamCheckedBox.isChecked();

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.checkbox1);
        boolean isChocolateChecked = ChocolateCheckBox.isChecked();

        EditText word = (EditText) findViewById(R.id.edit);
        String value = word.getText().toString();

        int price = calculatePrice(hasWhippedCream, isChocolateChecked);
        String message = summary(price, hasWhippedCream, isChocolateChecked, value);
        displayMessage(message);
    }

    private String summary (int price, boolean addWhippedCream, boolean isChocolateChecked, String value ){
        String name = value;
        name += "\nAdd whipped cream?" + addWhippedCream;
        name += "\nAdd Chocolate too?" + isChocolateChecked;
        name = name + "\nQuantity : " + quantity;
        name = name + "\nTotal Rs: " + price;
        name = name + "\nThank You!";
        return name;
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int price = 10;

        if(addWhippedCream){
            price = 2 + price;
        }

        if(addChocolate){
            price = 4 + price;
        }


        return price * quantity;
    }

    /**
     * This is an increment operator
     */

    public void increment(View view){
        if (quantity == 100){
            Toast.makeText(this, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This is a decrement operator
     */

    public void dec(View view){
        if (quantity == 1){
            Toast.makeText(this, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}