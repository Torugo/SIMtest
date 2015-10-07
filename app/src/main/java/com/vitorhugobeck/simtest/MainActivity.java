package com.vitorhugobeck.simtest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    void getSimData(){
        SubscriptionManager manager = SubscriptionManager.from(this);
        List<SubscriptionInfo> sil = manager.getActiveSubscriptionInfoList();

        if (sil != null) {
            for (SubscriptionInfo subInfo : sil) {
                Log.v("TestVitor", "SubInfo:" + subInfo.getSubscriptionId());
            }
        } else {
            Log.v("TestMain", "SubInfo: list is null");
        }
    }
//    void getSimData() {
//        String dbgMsg = "";
//        TelephonyManager  telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        int phoneCount=0;
//        int simState = telephonyManager.getSimState();
//        String simOperatorCode = null; //, simCountry, simOperatorName, simSerial;
//        switch (simState) {
//
//            case (TelephonyManager.SIM_STATE_ABSENT): {
//                Toast.makeText(getApplicationContext(), "NO SIM PRESENT", Toast.LENGTH_LONG).show();
//                break;
//            }
//            case (TelephonyManager.SIM_STATE_NETWORK_LOCKED): break;
//            case (TelephonyManager.SIM_STATE_PIN_REQUIRED): break;
//            case (TelephonyManager.SIM_STATE_PUK_REQUIRED): break;
//            case (TelephonyManager.SIM_STATE_UNKNOWN): break;
//            case (TelephonyManager.SIM_STATE_READY): {
//
//                // Get the SIM country ISO code
//                ((TextView)findViewById(R.id.isoCode)).setText(telephonyManager.getSimCountryIso());
//
//                // Get the operator code of the active SIM (MCC + MNC)
//                ((TextView)findViewById(R.id.simMCC)).setText(telephonyManager.getSimOperator());
//
//                // Get the name of the SIM operator
//                ((TextView)findViewById(R.id.operatorName)).setText(telephonyManager.getSimOperatorName());
//
//                // Get the SIM’s serial number
//                ((TextView)findViewById(R.id.SerialNumber)).setText(telephonyManager.getSimSerialNumber());
//
//                //Get the SIM's IMSI
//                ((TextView)findViewById(R.id.IMSICode)).setText(telephonyManager.getSubscriberId());
//
//                //Print the time to assure the data is recently collected
//
//                DateFormat df = new SimpleDateFormat("HH:mm:ss");
//                Calendar cal_hoje = Calendar.getInstance();
//                ((TextView)findViewById(R.id.time)).setText(df.format(cal_hoje.getTime()));
//                Toast.makeText(getApplicationContext(), "Data Collected", Toast.LENGTH_LONG).show();
//
//                int currentapiVersion = android.os.Build.VERSION.SDK_INT;
//                if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP_MR1){
//                    dbgMsg = String.valueOf(telephonyManager.getPhoneCount());
//                }
//                ((TextView)findViewById(R.id.debugMessages)).setText(dbgMsg);
//                break;
//            }
//        }
//    }

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

        return super.onOptionsItemSelected(item);
    }
}
