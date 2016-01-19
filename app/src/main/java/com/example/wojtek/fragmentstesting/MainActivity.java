package com.example.wojtek.fragmentstesting;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

//class MojFragment1 extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return new TextView(getActivity()) {{
//            setText("Jestem fragmentem");
//
//        }};
//
//    }
//}



public class MainActivity extends ActionBarActivity {

    private MojFragment2 fragment2;
    private MojFragment1 fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if(savedInstanceState != null)
//            savedInstanceState.remove("android:support:fragments");
//            for (String key : savedInstanceState.keySet()){
//                Object value = savedInstanceState.get(key);
//                Log.i("test", String.format("w bundlu pod kluczem %s mam %s", key,value));
//            }
        super.onCreate(savedInstanceState);
//        System.out.println("test" + savedInstanceState);

//        View v = findViewById(R.id.layout);
        setContentView(R.layout.activity_main);
        Log.i("test1", "nci" + getLastNonConfigurationInstance());
        Log.i("test1", "cnci"+ getLastCustomNonConfigurationInstance());


//        FrameLayout fl = new FrameLayout(this);
//        fl.setId(1337);
//        setContentView(fl);
//        FragmentManager fm = getSupportFragmentManager();
//        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(1337, new MojFragment1());
//        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(1, 1, 1, "dodaj fragment A");
        menu.add(1,2,2,"dodaj fragment B");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        FragmentManager fm1 = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft1 = fm1.beginTransaction();
//        if(item.getItemId() == 1 || item.getItemId() == 2) {

        if(item.getItemId() == 1) {
//            if(item.getItemId() == 1){
//                DialogFragment dialogFragment = new DialogFragment().
//            }
//            Fragment fragment = item.getItemId() ==1 ? new MojFragment1() : new MojFragment2();
            fragment1 = MojFragment1.create(4);
//            fragment1.helo("awsome");
            fragment1.setRetainInstance(true);
//            ft1.replace(R.id.layout, item.getItemId() ==1 ? new MojFragment1() : new MojFragment2());
            ft1.replace(R.id.layout, fragment1);
//            ft1.addToBackStack(null);
            ft1.commit();
            fm1.executePendingTransactions();
            MojFragment1 a = ((MojFragment1)getSupportFragmentManager().findFragmentById(R.id.layout));
            if(a != null)
                a.helo("hauhauah");




        }
        else if(item.getItemId() == 2) {
            fragment2 = MojFragment2.create(5);
            fragment2.setRetainInstance(true);
            ft1.replace(R.id.layout, fragment2);
//            ft1.addToBackStack(null);
            ft1.commit();
            fm1.executePendingTransactions();

            Fragment b = (getSupportFragmentManager().findFragmentById(R.id.layout));
            if (b instanceof MojFragment2) {
                if (b != null)
                    ((MojFragment2)b).helo("hauhauah");
            }
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        System.out.println("Zniszczylo");
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return "dzieci jakies";
    }
}
