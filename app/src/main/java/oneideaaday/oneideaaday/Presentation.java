package oneideaaday.oneideaaday;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * Created by edouarddupont on 28/03/15.
 */
public class Presentation extends Activity {

     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public void sendMessage (View view) {
        Intent intent = new Intent(this,Questionnaire.class);
        startActivity(intent);
        finish();
    }

}
