package hikst.frontendg4.client;

import com.google.gwt.user.client.Cookies;

import hikst.frontendg4.shared.JSONException;
import hikst.frontendg4.shared.JSONObject;

public class HikstCookie {

	private JSONObject jsonObject;
	private final String HIKST_COOKIE = "hikst";
	
	public HikstCookie()
	{
		try {
			jsonObject = new JSONObject(Cookies.getCookie(HIKST_COOKIE));
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
