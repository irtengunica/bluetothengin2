package com.example.okul.bluetothengin2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ac;
    Button kapat;
    Button gorunurYap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac=(Button)findViewById(R.id.ac);
        gorunurYap =(Button)findViewById(R.id.gyap);
        kapat=(Button)findViewById(R.id.kapat);
        final BluetoothAdapter adaptor = BluetoothAdapter.getDefaultAdapter();
        ac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(adaptor == null )
                {
                    Toast.makeText(MainActivity.this, "Blueetoth Aygýtý Bulunamadý", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(!adaptor.isEnabled())
                    {
                        Intent bluetoothBaslat = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(bluetoothBaslat,1);
                        Toast.makeText(MainActivity.this, "Bluetooth Ayýgýtý Açýk", Toast.LENGTH_SHORT).show();
                    }
                    else {adaptor.disable();}
                }
            }
        });
        gorunurYap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub

                Intent gorunurYap = new Intent (adaptor.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(gorunurYap,1);
                Toast.makeText(MainActivity.this, "Görünür Hale geldi", Toast.LENGTH_SHORT).show();


            }
        });
        kapat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                if(!adaptor.isEnabled())
                {}else{
                    adaptor.disable();
                    Toast.makeText(MainActivity.this, "Kapatýldý", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
