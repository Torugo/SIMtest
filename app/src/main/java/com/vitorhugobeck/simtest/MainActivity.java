package com.vitorhugobeck.simtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnData = (Button) findViewById(R.id.btnGet);
        btnData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSimData();
            }
    });
    }

    void getSimData() {
        TelephonyManager  telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telephonyManager.getSimState();
        String simOperatorCode = null; //, simCountry, simOperatorName, simSerial;
        switch (simState) {

            case (TelephonyManager.SIM_STATE_ABSENT): {

                break;
            }
            case (TelephonyManager.SIM_STATE_NETWORK_LOCKED): break;
            case (TelephonyManager.SIM_STATE_PIN_REQUIRED): break;
            case (TelephonyManager.SIM_STATE_PUK_REQUIRED): break;
            case (TelephonyManager.SIM_STATE_UNKNOWN): break;
            case (TelephonyManager.SIM_STATE_READY): {

                // Get the SIM country ISO code
                ((TextView)findViewById(R.id.isoCode)).setText(telephonyManager.getSimCountryIso());

                // Get the operator code of the active SIM (MCC + MNC)
                ((TextView)findViewById(R.id.simMCC)).setText(telephonyManager.getSimOperator());

                // Get the name of the SIM operator
                ((TextView)findViewById(R.id.operatorName)).setText(telephonyManager.getSimOperatorName());

                // Get the SIM’s serial number
                ((TextView)findViewById(R.id.SerialNumber)).setText(telephonyManager.getSimSerialNumber());

                //Get the SIM's IMSI
                ((TextView)findViewById(R.id.IMSICode)).setText(telephonyManager.getSubscriberId());
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.test){
            Toast.makeText(getApplicationContext(), "teste feito com sucesso", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
