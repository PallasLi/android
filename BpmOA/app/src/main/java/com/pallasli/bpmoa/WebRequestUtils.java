package com.pallasli.bpmoa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lyt1987 on 16/10/5.
 */
public class WebRequestUtils {
    ProgressDialog pd;
    TextView tv;
    private TextView mTvMsg;

    private String result;

    public   void openAsyncRequest(final Activity activity) {

        AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String urlstr = params[0];
                HttpURLConnection
                        connection = null;
                try {
                    URL url = new URL("http://192.168.43.245:8060/base/leave/add");
                    connection = (HttpURLConnection) url.openConnection();
                    // 设置请求方法，默认是GET
                    connection.setRequestMethod("POST");
                    // 设置字符集
                    connection.setRequestProperty("Charset", "UTF-8");
//                    // 设置文件类型
//                    connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
//                    // 设置请求参数，可通过Servlet的getHeader()获取
//                    connection.setRequestProperty("Cookie", "AppName=" + URLEncoder.encode("你好", "UTF-8"));
//                    // 设置自定义参数
//                    connection.setRequestProperty("MyProperty", "this is me!");
//                    connection.setRequestProperty("leavename", "标题");
//                    connection.setRequestProperty("memo", "memo");

                    connection.setDoInput(true);
                    StringBuffer urlparams=new StringBuffer();
                    urlparams.append("leavename=标题&memo=memo");
                    connection.getOutputStream().write(urlparams.toString().getBytes());

                    if (connection.getResponseCode() == 200) {
                        InputStream is = connection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(is);
                        BufferedReader reader = new BufferedReader(inputStreamReader);
                        String tempLine = null;
                        StringBuffer resultBuffer = new StringBuffer();
                        while ((tempLine = reader.readLine()) != null) {
                            resultBuffer.append(tempLine);
                        }
                        result = resultBuffer.toString();
                        Message msg = Message.obtain();
                        msg.what = 0;
                        getHandler.sendMessage(msg);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

                return result;
            }

            private Handler getHandler = new Handler() {
                public void handleMessage(android.os.Message msg) {
                    if (msg.what == 0 && result != null) {
                        //mTvMsg.setText(result);
                        Toast.makeText(activity,result,Toast.LENGTH_LONG);

                    }
                }

                ;
            };

            @Override
            protected void onPostExecute(String result) {
                pd.dismiss();// 消除dialog
                if (result != null) {
                    Toast.makeText(activity,result,Toast.LENGTH_LONG);
                    //tv.setText(result);
                }
                super.onPostExecute(result);
            }
        };
        pd = ProgressDialog.show(activity, "请稍后。。。", "正在请求数据");
        asyncTask.execute("http://localhost:8060/base/leave/add");
    }

}
