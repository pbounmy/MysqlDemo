package myapp.bmp.com.mysqldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myapp.bmp.com.mysqldemo.Fragment.FragmentInsertData;
import myapp.bmp.com.mysqldemo.Fragment.FragmentMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMain,new FragmentMenu())
                    .commit();

        }
    }
}
