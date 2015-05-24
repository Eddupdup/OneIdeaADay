package oneideaaday.oneideaaday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.PhantomReference;

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
        xp.setText("You have " + Xp + " Xp");
        ProgressBar progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);
        progressBar.setMax(80);
        progressBar.setProgress(Xp);
        return rootview;
    }
}
