//package com.thedesignerx.saim.new_message_app
//
//import android.content.Context
//import android.content.Intent
//import android.os.AsyncTask
//import android.widget.Toast
//import java.io.*
//import java.net.HttpURLConnection
//import java.net.MalformedURLException
//import java.net.URL
//import java.net.URLEncoder
//
//class BackGroundTaskLogin internal constructor(var ctx: Context) : AsyncTask<String?, Void?, String?>() {
//    var logdin = false
//    override fun onPreExecute() {
//        super.onPreExecute()
//    }
//
//    protected override fun doInBackground(vararg params: String): String? {
//        val log_url = "http://192.168.1.7:9090/loginapp/login.php"
//        val method = params[0]
//        if (method == "login") {
//            val username = params[1]
//            val password = params[2]
//            try {
//                val url = URL(log_url)
//                val httpURLConnection = url.openConnection() as HttpURLConnection
//                httpURLConnection.requestMethod = "POST"
//                httpURLConnection.doOutput = true
//                httpURLConnection.doInput = true
//                httpURLConnection.useCaches = false
//                val outputStream = httpURLConnection.outputStream
//                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
//                val login_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
//                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
//                bufferedWriter.write(login_data)
//                bufferedWriter.flush()
//                bufferedWriter.close()
//                val inputStream = httpURLConnection.inputStream
//                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
//                val result = StringBuilder()
//                var line: String? = ""
//                while (bufferedReader.readLine().also { line = it } != null) {
//                    result.append(line)
//                }
//                return result.toString()
//            } catch (e: MalformedURLException) {
//                e.printStackTrace()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//        return null
//    }
//
//    protected override fun onProgressUpdate(vararg values: Void) {
//        super.onProgressUpdate(*values)
//    }
//
//    override fun onPostExecute(result: String?) {
//        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show()
//        if (result == "Welcome user") {
//            logdin = true
//        }
//        if (logdin) {
//            val intent = Intent(ctx, MainActivity::class.java)
//            ctx.startActivity(intent)
//        }
//    }
//
//}