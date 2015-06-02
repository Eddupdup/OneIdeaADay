package oneideaaday.oneideaaday;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pierreluigiFort on 02/06/15.
 */
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

public class Favoris extends Fragment {

    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.favoris, container, false);
        final Button button3 = (Button) rootview.findViewById(R.id.button3);
        final Button button4 = (Button) rootview.findViewById(R.id.button4);
        final Button button5 = (Button) rootview.findViewById(R.id.button5);
        final Button button6 = (Button) rootview.findViewById(R.id.button6);
        final Button button7 = (Button) rootview.findViewById(R.id.button7);

        button3.setClickable(true);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien1));

                startActivity(browse);

                browse.setData(Uri.parse(lien1));
            }

        });

        button4.setClickable(true);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien2));

                startActivity(browse);

                browse.setData(Uri.parse(lien2));
            }

        });

        button5.setClickable(true);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien3));

                startActivity(browse);

                browse.setData(Uri.parse(lien3));
            }

        });

        button6.setClickable(true);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien4));

                startActivity(browse);

                browse.setData(Uri.parse(lien4));
            }

        });

        button7.setClickable(true);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(lien5));

                startActivity(browse);

                browse.setData(Uri.parse(lien5));
            }

        });



        return rootview;
    }

    //Lien exterieur
    public String lien1 = "https://fr.linkedin.com/in/floriancaringi";
    public String lien2 = "https://fr.linkedin.com/in/bostanci";
    public String lien3 = "https://fr.linkedin.com/pub/aubin-mermet/aa/284/939";
    public String lien4 = "https://fr.linkedin.com/in/edouarddupont";
    public String lien5 = "https://fr.linkedin.com/in/pierreluigifort";

    //Setteur classique pour le lien en string
    public void setLien(String lien) {
        this.lien1 = lien;
        this.lien2 = lien;
        this.lien3 = lien;
        this.lien4 = lien;
        this.lien5 = lien;
    }
}

