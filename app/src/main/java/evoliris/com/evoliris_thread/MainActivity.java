package evoliris.com.evoliris_thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import evoliris.com.evoliris_thread.task.DemoAsyncTask;


public class MainActivity extends ActionBarActivity implements DemoAsyncTask.DemoAsyncTaskCallback {

    private Button btnMaindLoad;
    private TextView tvMainText;
    private ProgressBar pbMainProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMaindLoad=(Button)findViewById(R.id.btn_main_load);
        tvMainText=(TextView)findViewById(R.id.tv_main);
        pbMainProgress=(ProgressBar)findViewById(R.id.pb_main_progress);

        btnMaindLoad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DemoAsyncTask demoAsyncTask= new DemoAsyncTask();
                demoAsyncTask.setCallback(MainActivity.this);
                demoAsyncTask.execute("url");

            }
        });

    }

    @Override
    public void preUpdateUI() {

        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void progressUpdateUI(int i) {
        pbMainProgress.setProgress(i);

    }

    @Override
    public void postUpdateUI(String s) {
        tvMainText.setText(s);
        Toast.makeText(this,"Loaded !", Toast.LENGTH_SHORT).show();

    }


    public class MyAsyncTask extends AsyncTask<String, Integer, String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
