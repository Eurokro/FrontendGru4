package hikst.frontendg4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetStatusCallback implements AsyncCallback<Integer>
{
	MyDockLayoutPanel panel;
	DatabaseServiceAsync databaseService = GWT.create(DatabaseService.class);
	
	public GetStatusCallback(MyDockLayoutPanel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(Integer result) {
		
		if(result == 4)
		{
			panel.updateStatus("Ferdig");
			panel.simulationFinished = true;
		}
		else if(result == 3)
		{
			panel.updateStatus("I k�");
		}
		else if(result == 2)
		{
			panel.updateStatus("Ikke i k�");
		}
		else
		{
			panel.updateStatus("Invalid simulation status detected... : "+result);
		}
		
	}

}

