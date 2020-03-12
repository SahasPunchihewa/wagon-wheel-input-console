package httpRequestHandler;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ReqHandler {

	public static void addShot(int playerID, String playerTeam, int playerSession, int scoreShot, float scoreX, float scoreY) throws IOException {

		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "playerID=" + playerID + "&playerTeam=" + playerTeam + "&playerSession=" + playerSession + "&scoreShot=" + scoreShot + "&scoreX=" + scoreX + "&scoreY=" + scoreY);
		Request request = new Request.Builder()
				.url("http://ec2-18-217-163-34.us-east-2.compute.amazonaws.com:8080/api/score")
				.method("POST", body)
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.build();

		Response response = client.newCall(request).execute();
	}

	public static ResponseBody playerList(String playerTeam) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		Request request = new Request.Builder()
				.url("http://ec2-18-217-163-34.us-east-2.compute.amazonaws.com:8080/api/player/" + playerTeam)
				.method("GET", null)
				.build();
		Response response = client.newCall(request).execute();

		return response.body();

	}

	public static void main(String[] args) throws IOException {

		addShot(1,"RCG", 1, 6, 100.0f, 20.5f);
		String jsonObject=playerList("MCG").string();
		JSONObject jObject=new JSONObject(jsonObject);
		JSONArray jarray=jObject.getJSONArray("");

//		System.out.println(playerList("MCG").string());

	}
}
