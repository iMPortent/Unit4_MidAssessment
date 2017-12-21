package nyc.c4q.unit4_midassessment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MarckemX on 12/20/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Book>books;

    public MyAdapter(ArrayList<Book>books){
        this.books = books;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.onBind(books.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
