package myapp.bmp.com.mysqldemo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import myapp.bmp.com.mysqldemo.R;

public class FragmentMenu extends Fragment {
    private Button btninsert,btnselect;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragmentmenu,container,false);
        btninsert =v.findViewById(R.id.btnInsertData);
        btnselect = v.findViewById(R.id.btnSelete);
        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMain,new FragmentShowData())
                        .addToBackStack(null)
                        .commit();
            }
        });
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMain,new FragmentInsertData())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return v;
    }
}
