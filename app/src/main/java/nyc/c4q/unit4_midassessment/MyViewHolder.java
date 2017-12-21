package nyc.c4q.unit4_midassessment;


import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MarckemX on 12/20/17.
 */

public class MyViewHolder extends ViewHolder {

    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.book_title);
    }

    public void onBind(String text){
        textView.setText(text);
    }
}
