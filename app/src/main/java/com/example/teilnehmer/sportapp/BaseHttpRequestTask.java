package com.example.teilnehmer.sportapp;

import android.os.AsyncTask;
import android.util.Log;

import com.example.teilnehmer.sportapp.protocol.Command;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * Basisklasse für alle Tasks, die mit dem Server kommunizieren. Die Klasse
 * stellt sicher, dass die Tasks außerhalb des UI Thread ausgeführt werden und
 * sorgt dafür, dass Aktionen nach Antwort des Servers wieder im UI-Thread
 * erfolgen (Methode OnPostExecute in den abgeleiteten Klassen).
 * 
 * @author Martin Pabst, 2016
 * 
 */
public abstract class BaseHttpRequestTask extends
		AsyncTask<String, Void, String> {



	/**
	 * Diese Methode wird nach Aufruf von execute() in einem neuen Thread
	 * ausgeführt. Der 0-te übergebene Parameter ist die String-Repräsentation
	 * des Command-Objekts, der 1-te übergebene Parameter ist der Body
	 * des POST-Requests.
	 *
	 * params[0]: URL
	 * params[1]: Command
	 * params[2]: Json
	 *
	 */
	@Override
	protected String doInBackground(String... params) {

		String result = "Fehler!";

		try {
			URL url = new URL("http://" + params[0] + "/sportfest/" + params[1]);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"application/xml; charset=UTF-8");

			byte[] outputInBytes = params[2].getBytes("UTF-8");
			OutputStream os = conn.getOutputStream();
			os.write(outputInBytes);
			os.close();

			InputStream instream = new BufferedInputStream(
					conn.getInputStream());

			BufferedReader r = new BufferedReader(new InputStreamReader(
					instream, "UTF-8"));

			StringBuilder total = new StringBuilder();

			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}

			instream.close();

			result = total.toString();

		} catch (Exception e) {

			Log.i("Response-Exception", e.toString());
		}

		/**
		 * Nach den return wird automatisch onPostExecute im UI-Thread
		 * aufgerufen.
		 */
		return result;
	}

	/**
	 * 
	 * Hilfsmethode, um einen XML-String in einen Objektbaum zu konvertieren
	 * 
	 * @param json
	 *            XML-String
	 * @param myClass
	 *            Klasse des Root-Objekts des Objektbaums
	 * @return Root-Objekt des Objektbaums
	 * @throws Exception
	 */
	protected Object deserialize(String json, Class myClass) {

		Gson gson = new Gson();

		Log.e("json", json);

		return gson.fromJson(json, myClass);

	}

	/**
	 * Hilfsmethode, um einen Objektbaum nach Json zu konvertieren
	 * 
	 * @param object
	 *            Root-Objekt des Objektbaums
	 * @return Json-String
	 * @throws Exception
	 */
	protected String serialize(Object object){

		Gson gson = new Gson();

		return gson.toJson(object);

	}

	protected void execute(String url, Command command, String postBody){
		super.execute(url, command.toString(), postBody);
	}
	
}
