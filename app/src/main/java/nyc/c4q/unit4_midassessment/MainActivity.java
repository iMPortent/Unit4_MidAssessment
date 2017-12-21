package nyc.c4q.unit4_midassessment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
}
