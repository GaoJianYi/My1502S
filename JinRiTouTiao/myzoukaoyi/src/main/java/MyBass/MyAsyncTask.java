package MyBass;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * date:2017/4/7
 * author:高坚译（dell）
 * Time:21:31
 */

public class MyAsyncTask extends AsyncTask<String,Integer,String> {
    private getjson getjson;
    @Override
    protected String doInBackground(String... strings) {
        StringBuffer sbu = new StringBuffer();
        try{
            URL url = new URL(strings[0]);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.setReadTimeout(5000);
            connect.setConnectTimeout(5000);

            if(connect.getResponseCode()==200){
                InputStream ins = connect.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ins,"utf-8"));
                String inpo;
                while((inpo=br.readLine())!=null){
                    sbu.append(inpo);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return sbu.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        getjson.getjsonstr(s);
    }
    public interface getjson{
        public void getjsonstr(String str);
    }
    public void huidiao(getjson get){
        this.getjson=get;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}

