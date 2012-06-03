package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.LoginRequest;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.RegisterRequest;
import hikst.frontendg4.shared.SimulationRequest;
import hikst.frontendg4.shared.SimulationTicket;
import hikst.frontendg4.shared.SimulatorObject;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DatabaseService</code>.
 */
public interface DatabaseServiceAsync {

	void getData(int sim_description_id, AsyncCallback<List<Plot>> callback)
	throws IllegalArgumentException;
	void getSimulatorObject(int simulation_object_id, AsyncCallback<SimulatorObject> callback)
	throws IllegalArgumentException;
	void getSimulationDescriptionsIDs(AsyncCallback<List<Integer>> callback)
	throws IllegalArgumentException;
	void getSimulation(int sim_description_id, AsyncCallback<Description> callback)
	throws IllegalArgumentException;
	void getSimulations(AsyncCallback<List<Description>> callback)
	throws IllegalArgumentException;
	void authenticate(LoginRequest request, AsyncCallback<Boolean> callback) 
	throws IllegalArgumentException;
	void logOff(AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void register(RegisterRequest request, AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void exists(String username, AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void saveObject(SimulatorObject object, AsyncCallback<Integer> callback);
	void requestSimulation(SimulationRequest request,
			AsyncCallback<SimulationTicket> callback);
	void deleteObject(int object_id, AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void deleteSimulations(int id, AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void updateObject(int id ,SimulatorObject object, AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void changeAccessLevel(String username, String access_level,
			AsyncCallback<Boolean> callback)
	throws IllegalArgumentException;
	void getSimulationStatus(SimulationTicket ticket,
			AsyncCallback<Integer> callback);
}
