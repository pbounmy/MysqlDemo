package myapp.bmp.com.mysqldemo.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.*;

import myapp.bmp.com.mysqldemo.R;

public class FragmentInsertData extends Fragment {
    private Button btnSave;
    private EditText txtname,txtsurname;
 private TextView tvresult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentinsertdata,container,false);
       // btnSave =v.findViewById(R.id.btnsave);
        btnSave = (Button) v.findViewById(R.id.btnsave);
        tvresult =(TextView)v.findViewById(R.id.tvresult);
        txtname = v.findViewById(R.id.txtname);
        txtsurname = v.findViewById(R.id.txtsurname);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send s = new send();
                s.execute();
            }
        });



        return v;
    }
    private class send extends AsyncTask<String,String,String>{

        String strname = txtname.getText().toString().trim();
        String strsurname = txtsurname.getText().toString().trim();
        String msg="";
        @Override
        protected void onPreExecute() {
            tvresult.setText("Please wait inserting data..");
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c = DBConnet.getConnect();
                Modeltb mdl=new Modeltb(c);
                if(c==null){
                msg="Connection gose wrong";
                }else{
                   mdl.setName(txtname.getText().toString().trim());
                   mdl.setSurname(txtsurname.getText().toString().trim());
                   int r = mdl.InsertData();
                   if(r >0) {
                       msg = "Inserting successful!!!";
                   }else{
                       msg="Can not Insert data";
                   }
                }
                c.close();
            }catch (Exception e){

            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvresult.setText(msg);
        }
    }
}
