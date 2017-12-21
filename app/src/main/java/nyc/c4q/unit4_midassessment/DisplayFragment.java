package nyc.c4q.unit4_midassessment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MarckemX on 12/20/17.
 */

public class DisplayFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        init();
        return inflater.inflate(R.layout.display_fragment, container,false);

    }

    private void init(){
        FragmentManager top = getFragmentManager(), bottom = getFragmentManager();
        FragmentTransaction forTop = top.beginTransaction(), forBottom = bottom.beginTransaction();
        forTop.replace(R.id.top_fragment, new TopFragment());
        forBottom.replace(R.id.bottom_fragment, new BottomFragment());
        forTop.commit();
        forBottom.commit();
    }
}
