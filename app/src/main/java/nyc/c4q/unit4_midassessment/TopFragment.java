package nyc.c4q.unit4_midassessment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MarckemX on 12/20/17.
 */

public class TopFragment extends Fragment {
    TextView title, author, year;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.top_fragment, container, false);
        title = view.findViewById(R.id.top_title);
        author = view.findViewById(R.id.top_author);
        year = view.findViewById(R.id.top_year);

        if(getArguments() != null){
            title.setText(getArguments().getString("title"));
            author.setText(getArguments().getString("author"));
            year.setText(String.valueOf(getArguments().getInt("year")));
        }
        return view;
    }
}
