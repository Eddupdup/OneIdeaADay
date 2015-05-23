package oneideaaday.oneideaaday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Settings extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.settings, container, false);
        Button button = (Button) rootview.findViewById(R.id.alert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Myapp) getActivity().getApplication()).setzero();
                ((Myapp) getActivity().getApplication()).setfact1delivered(false);
                ((Myapp) getActivity().getApplication()).setfact2delivered(false);
                ((Myapp) getActivity().getApplication()).setfact3delivered(false);
            }
        });
        return rootview;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.alert);
    }



}