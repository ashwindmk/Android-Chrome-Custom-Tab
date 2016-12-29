package com.example.ashwin.chromecustomtabs;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUrlEditText;
    private Button mGoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        mUrlEditText = (EditText) findViewById(R.id.urlEditText);

        mGoButton = (Button) findViewById(R.id.goButton);
        mGoButton.setOnClickListener(this);
    }

    private void goToUrl()
    {
        String url = mUrlEditText.getText().toString();
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id)
        {
            case R.id.goButton:
                goToUrl();
                break;

            default:
                break;
        }
    }
}
