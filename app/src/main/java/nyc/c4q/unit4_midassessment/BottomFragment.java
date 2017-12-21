package nyc.c4q.unit4_midassessment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MarckemX on 12/20/17.
 */

public class BottomFragment extends Fragment {

    static Bookstore bookstore;
    JSONObject object;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_fragment, container , false);

        recyclerView = view.findViewById(R.id.the_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setUpJson();
        parseJson();



        return view;
    }




    public void parseJson() {
        ArrayList<Book> books = new ArrayList<>();
        bookstore = new Bookstore();
        try {
            for (int i = 0; i < object.getJSONArray("books").length(); i++) {
                Book newBook = new Book();
                JSONObject otherObject = (JSONObject) object.getJSONArray("books").get(i);
                newBook.title = otherObject.get("title").toString();
                newBook.author = otherObject.get("author").toString();
                newBook.year = Integer.parseInt(otherObject.get("year").toString());
                books.add(newBook);
            }

            bookstore.books = books;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        MyAdapter adapter = new MyAdapter(bookstore.books);
        recyclerView.setAdapter(adapter);
    }

    public void setUpJson(){
        object = new JSONObject();
        JSONArray books = new JSONArray();
        try {
            object.put("books", new JSONArray()
                    .put(new JSONObject()
                        .put("title","Northanger Abby")
                        .put("author","Austen, Jane")
                        .put("year","1814")
                    ).put(new JSONObject()
                        .put("title","War and Peace")
                        .put("author","Tolstoy, Leo")
                        .put("year","1865")

                    ).put(new JSONObject()
                        .put("title","Anna Karenina")
                        .put("author","Tolstoy, Leo")
                        .put("year","1875")
                    ).put(new JSONObject()
                        .put("title","Anna Karenina")
                        .put("author","Tolstoy, Leo")
                        .put("year","1875")
                    ).put(new JSONObject()
                        .put("title","Mrs.Dalloway")
                        .put("author","Woolf, Virginia")
                        .put("year","1925")));

//                "title": "Mrs. Dalloway",
//                    "author": "Woolf, Virginia",
//                    "year": 1925
//            },
//            {
//                "title": "The Hours",
//                    "author": "Cunnningham, Michael",
//                    "year": 1999
//            },
//            {
//                "title": "Huckleberry Finn",
//                    "author": "Twain, Mark",
//                    "year": 1865
//            },
//            {
//                "title": "Bleak House",
//                    "author": "Dickens, Charles",
//                    "year": 1870
//            },
//            {
//                "title": "Tom Sawyer",
//                    "author": "Twain, Mark",
//                    "year": 1862
//            }
//

        } catch(org.json.JSONException e){
            e.printStackTrace();
        }
    }
}
