package oneideaaday.oneideaaday;

/**
 * Created by edouarddupont on 08/04/15.
 * Modified by Mikael Bostanci
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fact_4 extends Fragment {

    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences pref = getActivity().getSharedPreferences("PREF",0);
        final SharedPreferences.Editor editor = pref.edit();
        rootview = inflater.inflate(R.layout.fact_4, container, false);
        final Button button = (Button) rootview.findViewById(R.id.button1);
        //final Button buttonfav = (Button) rootview.findViewById(R.id.buttonfav);
        button.setClickable(true);
        final boolean xpdelivered = pref.getBoolean("fact4delivered",false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xpdelivered==false) {
                    int xp = pref.getInt("xp",0);
                    //((Myapp) getActivity().getApplication()).addxp(40);
                    editor.putInt("xp",xp+40)
                            .apply();
                    xp = pref.getInt("xp",40);
                    int xpmax = pref.getInt("xpMax",80);
                    if (((MyActivity)getActivity()).canlevelUp(xp,xpmax)){
                        ((MyActivity)getActivity()).leveledup();
                    }
                    //((Myapp) getActivity().getApplication()).setfact1delivered(true);
                    editor.putBoolean("fact4delivered",true)
                            .apply();
                    button.setClickable(false);
                }
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien));
                startActivity(browse);
                browse.setData(Uri.parse(lien));

            }
        });

        //buttonfav.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        ((Myapp) getActivity().getApplication()).addFavoris(getString(R.string.title_fact_1));
        //    }
        //});

        return rootview;
    }

    //Lien exterieur
    public String lien = "https://youtu.be/Qj3KNnhbui0" ;

    //Setteur classique pour le lien en string
    public void setLien(String lien) {
        this.lien=lien;
    }










}
