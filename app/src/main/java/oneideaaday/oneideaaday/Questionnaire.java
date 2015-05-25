package oneideaaday.oneideaaday;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by edouarddupont on 28/03/15.
 */
public class Questionnaire extends Activity {
    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void sendMessage (View view) {
        SharedPreferences pref = getSharedPreferences("PREF",0);
        SharedPreferences.Editor editor = pref.edit();
        EditText editUser = (EditText) findViewById(R.id.enteruser);
        String userName = editUser.getText().toString();
        editor.putString("userName",userName)
                .apply();
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
        editor.putBoolean("used",true)
                .apply();
    }



}
