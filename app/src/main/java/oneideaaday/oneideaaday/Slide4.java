package oneideaaday.oneideaaday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by edouarddupont on 21/06/15.
 */

public class Slide4 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.slide4 , container, false);
        Button buttonAnswer = (Button) rootView.findViewById(R.id.button8);
        Button buttonSkip = (Button) rootView.findViewById(R.id.button9);
        final Intent intent1 = new Intent((Presentation)getActivity(),Questionnaire.class);
        final Intent intent2 = new Intent((Presentation)getActivity(),MyActivity.class);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
        return rootView;

    }
}
