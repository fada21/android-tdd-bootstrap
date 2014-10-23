package com.fada21.android.bootstrap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PlainActivityNoApc extends Activity implements View.OnClickListener {

    private TextView mTextViewDevice;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_plain);

        mTextViewDevice = (TextView) findViewById(R.id.tv_home_device);
        mTextViewDevice.setText(getString(R.string.device_screen_label, getString(R.string.device_screen)));

        mButton = (Button) findViewById(R.id.btn_home);
        mButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.plain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_home:
                Toast.makeText(this, R.string.btn_home_toast, Toast.LENGTH_SHORT).show();
        }
    }

}
