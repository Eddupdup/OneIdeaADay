package oneideaaday.oneideaaday;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


/**
 * Created by edouarddupont on 28/03/15.
 */
public class Resultats extends Activity {
    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        int[] answers = extras.getIntArray("answers");
        setContentView(R.layout.activity_resultats);
        TextView answer2 = (TextView) findViewById(R.id.textView20);
        TextView answer31 = (TextView) findViewById(R.id.textView28);
        TextView answer32 = (TextView) findViewById(R.id.textView29);
        TextView answer33 = (TextView) findViewById(R.id.textView30);
        TextView answer4 = (TextView) findViewById(R.id.textView22);
        TextView answer5 = (TextView) findViewById(R.id.textView24);
        TextView answer6 = (TextView) findViewById(R.id.textView26);
        if (answers[0]!=R.id.quest2answ1) {
            answer2.setTextColor(Color.parseColor("#008000"));
        };

        if ((answers[1]!=R.id.quest3answ1)&&(answers[1]!=0)) {
            answer31.setTextColor(Color.parseColor("#008000"));
        }
        if ((answers[3]!=R.id.quest3answ3)&&(answers[3]!=0)) {
            answer32.setTextColor(Color.parseColor("#008000"));
        }
        if ((answers[4]!=R.id.quest3answ4)&&(answers[4]!=0)) {
            answer33.setTextColor(Color.parseColor("#008000"));
        }

        if (answers[5]!=R.id.quest4answ3) {
            answer4.setTextColor(Color.parseColor("#008000"));
        }

        if (answers[6]!=R.id.quest5answ2) {
            answer5.setTextColor(Color.parseColor("#008000"));
        }

        if (answers[7]!=R.id.quest6answ3) {
            answer6.setTextColor(Color.parseColor("#008000"));
        }

    }

    public void onRestart () {
        super.onRestart();
        setContentView(R.layout.activity_resultats);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onclickButton(View view) {
        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
        finish();
    }

}
