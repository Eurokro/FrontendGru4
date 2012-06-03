package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.SimulatorObject;
import hikst.frontendg4.shared.LoginRequest;
import hikst.frontendg4.shared.RegisterRequest;
import hikst.frontendg4.shared.SimulationRequest;
import hikst.frontendg4.shared.SimulationTicket;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("database")
public interface DatabaseService extends RemoteService
{
	//for getting simulation data
	List<Integer> getSimulationDescriptionsIDs() throws IllegalArgumentException;
	List<Plot> getData(int sim_description_id) throws IllegalArgumentException;
	SimulatorObject getSimulatorObject(int simulation_object_id) throws IllegalArgumentException;
	Description getSimulation(int sim_description_id) throws IllegalArgumentException;
	List<Description> getSimulations() throws IllegalArgumentException;
	
	//User authentication management
	boolean authenticate(LoginRequest request);
	boolean logOff();
	boolean register(RegisterRequest request);
	boolean exists(String username);
	boolean changeAccessLevel(String username,String access_level);

	//simulation management
	int saveObject(SimulatorObject object);
	boolean updateObject(int id,SimulatorObject object);
	boolean deleteObject(int object_id);
	SimulationTicket requestSimulation(SimulationRequest request);
	boolean deleteSimulations(int id);
	int getSimulationStatus(SimulationTicket ticket);
	
	 
}
