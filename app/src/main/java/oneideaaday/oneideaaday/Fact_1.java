package oneideaaday.oneideaaday;

/**
 * Created by edouarddupont on 08/04/15.
 * Modified by Mikael Bostanci
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fact_1 extends Fragment {

    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fact_1, container, false);
        final Button button = (Button) rootview.findViewById(R.id.button1);
        final Button buttonfav = (Button) rootview.findViewById(R.id.buttonfav);
        button.setClickable(true);
        final boolean xpdelivered = ((Myapp) this.getActivity().getApplication()).getfact1delivered();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xpdelivered==false) {
                    ((Myapp) getActivity().getApplication()).addxp(40);
                    ((Myapp) getActivity().getApplication()).setfact1delivered(true);
                    button.setClickable(false);
                }
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien));
                startActivity(browse);
                browse.setData(Uri.parse(lien));
            }
        });

        buttonfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapp) getActivity().getApplication()).addFavoris(getString(R.string.title_fact_1));
            }
        });

        return rootview;
    }

    //Lien exterieur
    public String lien = "http://www.sciencesetavenir.fr/high-tech/20150504.OBS8380/avec-ses-nouvelles-batteries-tesla-veut-revolutionner-le-stockage-de-l-energie.html" ;

    //Setteur classique pour le lien en string
    public void setLien(String lien) {
        this.lien=lien;
    }










}
