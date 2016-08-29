package evoliris.com.evoliris_thread.task;

import android.os.AsyncTask;

/**
 * Created by temp on 29/08/2016.
 */
public class DemoAsyncTask extends AsyncTask<String, Integer, String> {


    private DemoAsyncTaskCallback callback;

    public void setCallback(DemoAsyncTaskCallback callback){
        this.callback=callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(callback!=null) {
            callback.preUpdateUI();
        }
    }

    @Override
    protected String doInBackground(String... params) {
        //publishProgress(5);

        for (int i = 0; i <100 ; i++) {
            publishProgress(i+1);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return "ce tex a été chargé dans une AsyncTask !";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if(callback!=null){
            for(int i: values){
                callback.progressUpdateUI(i);
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(callback!=null){
            callback.postUpdateUI(s);
        }
    }

    public interface DemoAsyncTaskCallback{
        void preUpdateUI();
        void progressUpdateUI(int i);
        void postUpdateUI(String s);
    }
}
