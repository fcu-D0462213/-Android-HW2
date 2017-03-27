package com.example.hw2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=(TextView)findViewById(R.id.tv_result);
        input=(EditText)findViewById(R.id.et_input);
        submit=(Button)findViewById(R.id.btn_sumbit);
        submit.setOnClickListener(calcResult);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    private OnClickListener calcResult=new OnClickListener(){

        @Override
        public void onClick(View v) {
            String input_str=input.getText().toString();
            //input.setText("");
            if(input_str.length()==0){
                Toast.makeText(MainActivity.this,
                        "No Name input",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(MainActivity.this,
                    oput(input_str),
                    Toast.LENGTH_SHORT).show();
            //result.setText(oput(input_str));
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_about:
                AlertDialog.Builder ad=new AlertDialog.Builder(this);
                ad.setTitle(" About this APP");
                ad.setMessage("Author:Burning Wang");

                DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di, int i){
                    }
                };
                ad.setPositiveButton("OK",listener);
                ad.show();
                break;
            case R.id.action_reset:
                //String input_str=input.getText().toString();
                input.setText("");
                break;
        }
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
    private String oput(String input_str){
        String result=new String();
        if(input_str==null)
        {
            return input_str;
        }
        //result=(String)getText(R.string.result);
        result="Hello "+input_str;
        return  result;
    }
}
