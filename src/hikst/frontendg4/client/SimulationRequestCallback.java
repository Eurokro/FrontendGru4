package hikst.frontendg4.client;

import hikst.frontendg4.shared.SimulationTicket;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SimulationRequestCallback implements AsyncCallback<SimulationTicket> {

	MyDockLayoutPanel panel;
	
	public SimulationRequestCallback(MyDockLayoutPanel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(SimulationTicket result) {
		
		panel.setSimulationTicket(result);

	}

}
