package oneideaaday.oneideaaday;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        TextView xp = (TextView) rootview.findViewById(R.id.xp);
        int Xp = ((Myapp) this.getActivity().getApplication()).getXp();
        xp.setText("You have "+ Xp + "xp");

        return rootview;
    }




}
