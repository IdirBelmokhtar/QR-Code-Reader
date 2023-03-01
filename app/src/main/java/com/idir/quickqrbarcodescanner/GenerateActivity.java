package com.idir.quickqrbarcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateActivity extends AppCompatActivity {

    EditText edit_text;
    ImageView image_generate;
    Button generate;
    BarcodeFormat barcodeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        edit_text = findViewById(R.id.edit_text);
        image_generate = findViewById(R.id.image_generate);
        generate = findViewById(R.id.generate);

        Spinner spinCountry;
        spinCountry= (Spinner) findViewById(R.id.spinCountry);//fetch the spinner from layout file
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.country_array));//setting the country_array to spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCountry.setAdapter(adapter);

        spinCountry.setSelection(11);
        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if (spinCountry.getSelectedItemId() == 0){barcodeFormat = BarcodeFormat.AZTEC;}
                if (spinCountry.getSelectedItemId() == 1){barcodeFormat = BarcodeFormat.CODABAR;}
                if (spinCountry.getSelectedItemId() == 2){barcodeFormat = BarcodeFormat.CODE_39;}
                if (spinCountry.getSelectedItemId() == 3){barcodeFormat = BarcodeFormat.CODE_93;}
                if (spinCountry.getSelectedItemId() == 4){barcodeFormat = BarcodeFormat.CODE_128;}
                if (spinCountry.getSelectedItemId() == 5){barcodeFormat = BarcodeFormat.DATA_MATRIX;}
                if (spinCountry.getSelectedItemId() == 6){barcodeFormat = BarcodeFormat.EAN_8;}
                if (spinCountry.getSelectedItemId() == 7){barcodeFormat = BarcodeFormat.EAN_13;}
                if (spinCountry.getSelectedItemId() == 8){barcodeFormat = BarcodeFormat.ITF;}
                if (spinCountry.getSelectedItemId() == 9){barcodeFormat = BarcodeFormat.MAXICODE;}
                if (spinCountry.getSelectedItemId() == 10){barcodeFormat = BarcodeFormat.PDF_417;}
                if (spinCountry.getSelectedItemId() == 11){barcodeFormat = BarcodeFormat.QR_CODE;}
                if (spinCountry.getSelectedItemId() == 12){barcodeFormat = BarcodeFormat.RSS_14;}
                if (spinCountry.getSelectedItemId() == 13){barcodeFormat = BarcodeFormat.RSS_EXPANDED;}
                if (spinCountry.getSelectedItemId() == 14){barcodeFormat = BarcodeFormat.UPC_A;}
                if (spinCountry.getSelectedItemId() == 15){barcodeFormat = BarcodeFormat.UPC_E;}
                if (spinCountry.getSelectedItemId() == 16){barcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;}
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(edit_text.getText().toString(), barcodeFormat, 400, 400);
                    image_generate.setImageBitmap(bitmap);
                } catch(Exception e) {

                }
            }
        });

    }
}