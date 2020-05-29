//package com.thedesignerx.saim.new_message_app;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.widget.Toast;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class BackGroundTask extends AsyncTask<String, Void, String> {
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(ApiInterface.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    ReactRegister reactRegister = retrofit.create(ReactRegister.class);
//    Call<register> call = reactRegister.getRegister();
//
//    Context ctx;
//
//    BackGroundTask(Context ctx) {
//        this.ctx = ctx;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    @Override
//    protected String doInBackground(String... params) {
//
//        String reg_url = "http://192.168.1.7:9090/loginapp/register.php";
//        String method = params[0];
//        if (method.equals("register")) {
//            String email = params[1];
//            String username = params[2];
//            String password = params[3];
//            String confirmPassword = params[4];
//            try {
//                URL url = new URL(reg_url);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                httpURLConnection.setDoInput(true);
//                httpURLConnection.setUseCaches(false);
//                OutputStream outputStream = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
//                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
//                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
//                        URLEncoder.encode("confirmPassword", "UTF-8") + "=" + URLEncoder.encode(confirmPassword, "UTF-8");
//                bufferedWriter.write(data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
//
//                String result = "";
//                String line = "";
//
//                while ((line = bufferedReader.readLine()) != null) {
//                    result += line;
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void onProgressUpdate(Void... values) {
//        super.onProgressUpdate(values);
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
//    }
//}