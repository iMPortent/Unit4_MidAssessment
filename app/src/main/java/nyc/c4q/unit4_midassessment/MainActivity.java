package nyc.c4q.unit4_midassessment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static nyc.c4q.unit4_midassessment.BottomFragment.bookstore;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager, managerTwo;
    FragmentTransaction transaction, secondTrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_holder, new MainFragment());
        transaction.commit();
    }

    public void toDisplay(View view){
        managerTwo = getFragmentManager();
        secondTrans = manager.beginTransaction();
        secondTrans.replace(R.id.frag_holder, new DisplayFragment());
        secondTrans.commit();
    }


    public void sendData(View view){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TopFragment topFragment = new TopFragment();

        String title = view.toString();
        Bundle bundle = new Bundle();
        for(int i = 0; i < bookstore.books.size();i++){
            Book thisBook = bookstore.getBooks().get(i);
            if(title == thisBook.getTitle()){
                bundle.putString("title", thisBook.getTitle());
                bundle.putString("author", thisBook.getAuthor());
                bundle.putInt("year", thisBook.getYear());
            }
        }
        topFragment.setArguments(bundle);
        transaction.replace(R.id.top_fragment, topFragment);
    }

}
