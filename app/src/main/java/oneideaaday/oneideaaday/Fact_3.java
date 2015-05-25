package oneideaaday.oneideaaday;

/**
 * Created by edouarddupont on 08/04/15.
 */

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Fact_3 extends Fragment {

    private boolean xpdelivered;
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fact_3, container, false);

        final SharedPreferences  pref = getActivity().getPreferences(0);
        final SharedPreferences.Editor editor = pref.edit();
        //final boolean xpdelivered = ((Myapp) this.getActivity().getApplication()).getfact3delivered();
        final boolean xpdelivered = pref.getBoolean("fact3delivered",false);
        final ImageButton button = (ImageButton) rootview.findViewById(R.id.imageButton);
        //final int Xp = ((Myapp) getActivity().getApplication()).getXp();
        final int Xp = pref.getInt("xp",0);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setTitle("Défi Réalisé")
                    .setNeutralButton("Ok", null);

        if (xpdelivered==true) {
            button.setImageResource(R.drawable.realise);
            button.setClickable(false);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xpdelivered==false) {
                    editor.putInt("xp",Xp+40)
                            .apply();
                    //((Myapp) getActivity().getApplication()).addxp(40);
                    int xp = pref.getInt("xp",40);
                    int xpmax = pref.getInt("xpMax",80);
                    //((Myapp) getActivity().getApplication()).setfact3delivered(true);
                    editor.putBoolean("fact3delivered",true)
                            .apply();
                    button.setImageResource(R.drawable.realise);
                    button.setClickable(false);
                    //int xpactuel = ((Myapp) getActivity().getApplication()).getXp();
                    if (((MyActivity)getActivity()).canlevelUp(xp,xpmax)) {
                        ((MyActivity)getActivity()).leveledup();
                    }
                    else {
                        alertDialog.setMessage("Vous avez désormais " + xp + " Points d'expérience");
                        alertDialog.show();
                    }
                }

            }
        });

        return rootview;
    }
}
