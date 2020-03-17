package main.java.httpRequestHandler;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

public class ReqHandler extends main.java.MCG.WWheal
{
	public static void addShot(int playerID, String playerTeam, int playerSession, int scoreShot, float scoreX, float scoreY) throws IOException 
	{

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
	
	public static ResponseBody playerList(String playerTeam) throws IOException 
	{
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		Request request = new Request.Builder()
				.url("http://ec2-18-217-163-34.us-east-2.compute.amazonaws.com:8080/api/player/" + playerTeam)
				.method("GET", null)
				.build();
		Response response = client.newCall(request).execute();
		return response.body();
	}
	
	public static void main(String[] args) throws IOException 
	{
		//Json get from the Response body
		System.out.println("Main Array : "+ playerList("MCG").string());
		//Add Response body to the Json Array
		JSONArray jarray=new JSONArray(playerList("MCG").string());
		//Iterate on jArray to get Each players Details
		for (int i = 0; i <jarray.length() ; i++) 
		{	
			//Get Each Player Object 
			JSONObject jsonObject = jarray.getJSONObject(i);
			//Print Each players Details get from the object
			System.out.print(jsonObject.getInt("playerID"));
			System.out.print("\t\t"+jsonObject.getString("playerName"));
			
			playerlist[i]=jsonObject.getString("PlayerName");
			
			System.out.println();			
			//If you want you can create a Player Class and put all these details in to player type array list display those in the UI
		}
		addShot(1,"RCG", 1, 6, 100.0f, 20.5f);
		String jsonObject=playerList("MCG").string();
	}
}
