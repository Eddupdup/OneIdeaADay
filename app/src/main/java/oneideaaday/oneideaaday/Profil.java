package oneideaaday.oneideaaday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by edouarddupont on 28/03/15.
 */
public class Profil extends Fragment {
    View rootview;

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.profil, container, false);

        String username =((Myapp) getActivity().getApplication()).getUserName();
        TextView textView = (TextView) rootview.findViewById(R.id.username);
        textView.setText(username);

        TextView xp = (TextView) rootview.findViewById(R.id.xp);
        int Xp = ((Myapp) this.getActivity().getApplication()).getXp();
        int xpMax = ((Myapp) this.getActivity().getApplication()).getXpmax();

        if (Xp>xpMax) {
            int levelup = mod(Xp - xpMax,80)+1;
            ((Myapp) this.getActivity().getApplication()).addLevel(levelup);
            //((Myapp) this.getActivity().getApplication()).addXpmax(levelup*80);
        }

        xp.setText("Points d'Expérience : " + Xp + " / " + xpMax + " pts");

        ProgressBar progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);
        progressBar.setMax(xpMax);
        progressBar.setProgress(Xp);
        return rootview;
    }

    private int mod(int x, int y)
    {
        int result = x % y;
        if (result < 0)
            result += y;
        return result;
    }
}
