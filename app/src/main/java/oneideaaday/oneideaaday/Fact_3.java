package oneideaaday.oneideaaday;

/**
 * Created by edouarddupont on 08/04/15.
 */

import android.app.AlertDialog;
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
        final boolean xpdelivered = ((Myapp) this.getActivity().getApplication()).getfact3delivered();
        final ImageButton button = (ImageButton) rootview.findViewById(R.id.imageButton);
        final int Xp = ((Myapp) getActivity().getApplication()).getXp();
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
                    ((Myapp) getActivity().getApplication()).addxp(40);
                    ((Myapp) getActivity().getApplication()).setfact3delivered(true);
                    button.setImageResource(R.drawable.realise);
                    button.setClickable(false);
                    int xpactuel = ((Myapp) getActivity().getApplication()).getXp();
                    alertDialog.setMessage("Vous avez désormais " + xpactuel + " Points d'expérience");
                    alertDialog.show();
                }


            }
        });

        return rootview;
    }
}
