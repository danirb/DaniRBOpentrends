package com.devforbest.danirbopentrends.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.devforbest.danirbopentrends.adapters.ListRecyclerAdapter;
import com.devforbest.danirbopentrends.fragments.FragmentDetails;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import retrofit.Call;

/**
 * Created by dani on 9/01/16.
 */
public class GetList extends AsyncTask<Void, Context, List<ResponseModel.Result>> {
    private RecyclerView rv;
    private Context context;
    private ProgressDialog pDialog;
    private ResponseModel br;

    public GetList(Context context, RecyclerView rv) {
        this.context = context;
        this.rv = rv;
        this.pDialog = new ProgressDialog(context);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog.setMessage("Please wait.");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected List<ResponseModel.Result> doInBackground(Void... params) {
        br = null;
        Service client = ServiceGenerator.createService(Service.class);
        Call<ResponseModel> call = client.repoVillage();
        try {
            br = call.execute().body();
            writeFile(br.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return br.getResult();
    }

    private void writeFile(String str) throws IOException {
        FileWriter fw = new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/census/");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);
        bw.close();
    }

    @Override
    protected void onPostExecute(final List<ResponseModel.Result> aVoid) {
        pDialog.dismiss();
        ListRecyclerAdapter adapter = new ListRecyclerAdapter(aVoid, context);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FragmentDetails.class);
                i.putExtra("human", (Serializable) aVoid.get(rv.getChildAdapterPosition(v)));
                context.startActivity(i);
            }
        });

    }


}
