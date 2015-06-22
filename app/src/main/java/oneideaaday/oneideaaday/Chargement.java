package oneideaaday.oneideaaday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class Chargement extends ActionBarActivity {

    public static final int seconde = 5;
    public static final int milseconde = seconde * 1000;
    public static final int delay = 2;
    private ProgressBar MyBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);
        MyBar = (ProgressBar) findViewById(R.id.MyBar);
        MyBar.setMax(max_progress());
        beginanimate();
    }

    public void onStart() {
        super.onStart();

        //((Myapp)getApplication()).setFavoris(settings.getStringSet("favoris",((Myapp)getApplication()).getFavoris()));

    }

    public void beginanimate() {
        new CountDownTimer(milseconde, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                MyBar.setProgress(establish_progess(millisUntilFinished));
            }


            @Override
            public void onFinish() {
                final SharedPreferences pref = getSharedPreferences("PREF",0);
                boolean used =pref.getBoolean("used", false);
                boolean questionned = pref.getBoolean("questionned",false);
                if ((used==false)&&(questionned==false)) {
                    Intent intent = new Intent(Chargement.this, Presentation.class);
                    startActivity(intent);
                    finish();
                }
                if ((used==true)&&(questionned==false)) {
                    Intent intent = new Intent(Chargement.this,Questionnaire.class);
                    startActivity(intent);
                    finish();
                }
                if ((used==true)&&(questionned==true)){
                    Intent intent = new Intent(Chargement.this,MyActivity.class);
                    startActivity(intent);
                    finish();
                }
                if ((used==false)&&(questionned==true)){
                    Intent intent = new Intent(Chargement.this,Presentation.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }

    public int establish_progess(long miliseconds) {
        return (int) ((milseconde - miliseconds) / 1000);
    }

    public int max_progress() {
        return seconde - delay;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chargement, menu);
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
