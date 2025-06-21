package com.example.signuploginfirebase;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Sub1Chap2 extends AppCompatActivity {

    private TextView text1;
    private PDFView pdfView;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1_chap2);  // Correct layout for Sub1Chap2

        pdfView = findViewById(R.id.pdfView);
        text1 = findViewById(R.id.text1);
        backButton = findViewById(R.id.back_button);  // Get reference to back button

        // Set onClickListener to handle back button press
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();  // This will finish the activity and go back to the previous one
            }
        });

        // Use a simple public PDF URL for testing
        String publicPdfUrl = "https://firebasestorage.googleapis.com/v0/b/e-book-1149f.firebasestorage.app/o/Spoken%20English%20book%2FCh-2_Mass%26%20Spoken_compressed.pdf?alt=media&token=e1db6147-7497-46be-b8e2-7ecadaf79e89";
        new RetrievePdfStream().execute(publicPdfUrl);
        Toast.makeText(Sub1Chap2.this, "Loading PDF from public URL", Toast.LENGTH_SHORT).show();
    }

    // AsyncTask to download the PDF
    private class RetrievePdfStream extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                // Create a URL from the provided string
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                // Check the connection response code
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                } else {
                    Log.e("Download PDF", "Failed to connect: " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e("Download PDF", "Error downloading PDF: " + e.getMessage());
            }
            return inputStream; // Return the input stream
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            if (inputStream != null) {
                // Load the PDF from the InputStream and display it
                pdfView.fromStream(inputStream).load();
            } else {
                Toast.makeText(Sub1Chap2.this, "Error loading PDF", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
