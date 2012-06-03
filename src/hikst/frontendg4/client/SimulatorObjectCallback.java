package hikst.frontendg4.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import hikst.frontendg4.shared.*;

public class SimulatorObjectCallback implements AsyncCallback<SimulatorObject>
{
	SimulationManagementObject simulationManagementObject;
	
	SimulatorObjectCallback(SimulationManagementObject simulationManagementObject)
	{
		this.simulationManagementObject = simulationManagementObject;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(SimulatorObject result) {
		
		this.simulationManagementObject.load(result);
	}

}