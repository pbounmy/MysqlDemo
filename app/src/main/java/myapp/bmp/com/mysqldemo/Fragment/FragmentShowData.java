package myapp.bmp.com.mysqldemo.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import myapp.bmp.com.mysqldemo.R;

public class FragmentShowData extends Fragment {
    private Button btnload;
    private TextView tvload;
    private ListView lvshow;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragmentshowdata,container,false);
       btnload =v.findViewById(R.id.btnload);
       tvload = v.findViewById(R.id.tvload);
       lvshow = v.findViewById(R.id.lstview);
       btnload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               selectData sel = new selectData();
               sel.execute("");
           }
       });




        return v;
    }
    private class selectData extends AsyncTask<String,String,String>{
        ArrayList<String> arr = new ArrayList<String>();
        String msg="";
        ArrayAdapter<String> adt=null;
        @Override
        protected void onPostExecute(String s) {
            adt = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr);
            lvshow.setAdapter(adt);
            tvload.setText(msg);

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
            Connection c = DBConnet.getConnect();
            Modeltb mdl = new Modeltb(c);
                ResultSet rs = mdl.SelectData();
                arr.clear();
                while(rs.next()){
                    arr.add(rs.getString(2));
                    Log.e("Data","Data==>"+rs.getString(2));
                }
               rs.close();
                c.close();
                    msg="Load data complete!!!";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Can not Load data !!!";
            }


            return msg;
        }

        @Override
        protected void onPreExecute() {
            tvload.setText("Please wait loading data");
        }
    }
}
