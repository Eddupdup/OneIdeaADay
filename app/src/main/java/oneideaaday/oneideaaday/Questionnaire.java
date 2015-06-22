package oneideaaday.oneideaaday;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;


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

    public void onRestart () {
        super.onRestart();
        setContentView(R.layout.questionnaire);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void sendMessage (View view) {
        RadioGroup group2 = (RadioGroup) findViewById(R.id.group2);
        RadioGroup group4 = (RadioGroup) findViewById(R.id.groupe4);
        RadioGroup group5 = (RadioGroup) findViewById(R.id.groupe5);
        RadioGroup group6 = (RadioGroup) findViewById(R.id.groupe6);
        CheckBox check1 = (CheckBox) findViewById(R.id.quest3answ1);
        CheckBox check2 = (CheckBox) findViewById(R.id.quest3answ2);
        CheckBox check3 = (CheckBox) findViewById(R.id.quest3answ3);
        CheckBox check4 = (CheckBox) findViewById(R.id.quest3answ4);
        int selected2 = group2.getCheckedRadioButtonId();
        int selected4 = group4.getCheckedRadioButtonId();
        int selected5 = group5.getCheckedRadioButtonId();
        int selected6 = group6.getCheckedRadioButtonId();
        int[] answers = {selected2,0,0,0,0,selected4,selected5,selected6};
        //RadioButton answer2 = (RadioButton) findViewById(selected2);
        SharedPreferences pref = getSharedPreferences("PREF",0);
        SharedPreferences.Editor editor = pref.edit();
        int xp = pref.getInt("xp",0);
        int xpmax = pref.getInt("xpMax",80);
        EditText editUser = (EditText) findViewById(R.id.enteruser);
        String userName = editUser.getText().toString();

        editor.putString("userName",userName)
                .apply();
        if (selected2==R.id.quest2answ1) {
            editor.putInt("xp",xp+30)
                    .apply();
        }
        xp = pref.getInt("xp",0);
        if (selected4==R.id.quest4answ3) {
            editor.putInt("xp",xp+30)
                    .apply();
        }
        xp = pref.getInt("xp",0);
        if (selected5==R.id.quest5answ2) {
            editor.putInt("xp",xp+30)
                    .apply();
        }
        xp = pref.getInt("xp",0);
        if (selected6==R.id.quest6answ3) {
            editor.putInt("xp",xp+30)
                    .apply();
        }
        xp = pref.getInt("xp",0);
        if ((check1.isChecked())&&(check3.isChecked())&&(check4.isChecked())) {
            editor.putInt("xp", xp + 40);
            answers[1]=R.id.quest3answ1;
            answers[3]=R.id.quest3answ3;
            answers[4]=R.id.quest3answ4;
        }
        else {
            if (check1.isChecked()) {
                editor.putInt("xp",xp+10)
                        .apply();
                answers[1] = R.id.quest3answ1;
            }
            if (check2.isChecked()) {
                answers[2] = R.id.quest3answ2;
            }
            if (check3.isChecked()) {
                editor.putInt("xp",xp+10)
                        .apply();
                answers[3] = R.id.quest3answ3;
            }
            if (check4.isChecked()) {
                editor.putInt("xp",xp+10)
                        .apply();
                answers[4] = R.id.quest3answ4;
            }
        }
        xp = pref.getInt("xp",0);
        leveledup(answers);
        editor.putBoolean("questionned", true)
                .apply();;


    }

    public int giveanswer (int id) {
        RadioGroup radioGroup = (RadioGroup) findViewById(id);
        int answer = radioGroup.getCheckedRadioButtonId();
        return answer;
    }

    public boolean canlevelUp (int xp,int xpmax) {
        if (xp>=xpmax) {
            //((Myapp) getApplication()).addLevel(1);
            return true;
        }
        else return false;
    }

    public void leveledup (int[] answer) {
        final SharedPreferences pref = getSharedPreferences("PREF", 0);
        final SharedPreferences.Editor editor = pref.edit();
        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        final Intent intent = new Intent(this,MyActivity.class);
        final Intent intent1 = new Intent(this,Resultats.class);
        intent1.putExtra("answers",answer);
        //int xp = ((Myapp) getApplication()).getXp();
        //int xpmax = ((Myapp) getApplication()).getXpmax();
        //((Myapp) getApplication()).addLevel(1);
        int level = pref.getInt("level",1);
        int xp = pref.getInt("xp",0);
        int xpMax = pref.getInt("xpMax",80);
        if (xp>=xpMax) {
            double difXp = (double) (xp - xpMax) / 80;
            int defLevel = (int) (Math.floor(difXp) + 1);
            editor.putInt("level", level + defLevel)
                    .putInt("xpMax", xpMax + 80 * defLevel)
                    .apply();
        }
        int Level = pref.getInt("level",1);
        alertdialog.setTitle("Résultats")
                .setMessage("Maintenant que vous avez répondu au questionnaire, vous allez pourvoir profiter pleinement de l'application ! Allez voir votre niveau de départ dans votre profil. ") // +" "+ xp+" " + xpmax)
                .setPositiveButton("Suivant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(intent);
                        finish();
                    }
                })
                .setNeutralButton("Voir les réponses", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       startActivity(intent1);
                       finish();
                    }
                })
                .show();

    }



}
