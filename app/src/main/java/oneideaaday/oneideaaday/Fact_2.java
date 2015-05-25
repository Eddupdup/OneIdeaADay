package oneideaaday.oneideaaday;

/**
 * Created by edouarddupont on 08/04/15.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fact_2 extends Fragment {

    View rootview;

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fact_2, container, false);
        final SharedPreferences pref = getActivity().getSharedPreferences("PREF",0);
        final SharedPreferences.Editor editor = pref.edit();
        final boolean xpdelivered = pref.getBoolean("xpdelivered",false);
        final Button button = (Button) rootview.findViewById(R.id.button1);
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xpdelivered==false) {
                    //((Myapp) getActivity().getApplication()).addxp(40);
                    int xp = pref.getInt("xp",0);
                    editor.putInt("xp",xp+40)
                            .apply();
                    xp = pref.getInt("xp",40);
                    //int xp = ((Myapp)getActivity().getApplication()).getXp();
                    int xpmax = pref.getInt("xpMax",80);
                    if (((MyActivity)getActivity()).canlevelUp(xp,xpmax)){
                        ((MyActivity)getActivity()).leveledup();
                    }
                    //((Myapp) getActivity().getApplication()).setfact2delivered(true);
                    editor.putBoolean("fact2delivered",true)
                            .apply();
                    button.setClickable(false);
                }
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien));
                startActivity(browse);
                browse.setData(Uri.parse(lien));

            }
        });

        return rootview;
    }

    //Lien exterieur
    public String lien = "https://www.youtube.com/watch?v=81kTyScrtuQ" ;

    //Setteur classique pour le lien en string
    public void setLien(String lien) {
        this.lien=lien;
    }

}
