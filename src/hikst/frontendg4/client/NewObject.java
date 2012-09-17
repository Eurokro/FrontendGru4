package hikst.frontendg4.client;

import java.util.ArrayList;
import java.util.Iterator;


import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.SimulationRequest;
import hikst.frontendg4.shared.SimulationTicket;
import hikst.frontendg4.shared.SimulatorObject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;

public class NewObject extends Composite implements HasText {

	ObjectMenu panel;
	SimulatorObjectTree simulatorObject = new SimulatorObjectTree();
	//SimulationManagementObject simManager = new SimulationManagementObject(this);
	
	private static NewObjectUiBinder uiBinder = GWT
			.create(NewObjectUiBinder.class);
	@UiField TextBox impactFactor;
	@UiField TextBox effect;
	@UiField TextBox volt;
	@UiField TextBox name;
	@UiField TextBox longtitude;
	@UiField TextBox latitude;
	@UiField TextBox usagePattern;
	@UiField Button back;
	@UiField Button addObject;
	@UiField Button saveObject;
	@UiField Tree tree;
	
	private DatabaseServiceAsync databaseService = GWT.create(DatabaseService.class);
	
	
	interface NewObjectUiBinder extends UiBinder<Widget, NewObject> {
	}

	public NewObject() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@UiHandler("back")
	void onBackClick(ClickEvent event) {
		RootLayoutPanel.get().add(new ObjectMenu());
		panel = new ObjectMenu();
		RootLayoutPanel.get().add(panel);
	}
	
	@UiHandler("saveObject")
	void onSaveObject(ClickEvent event){
	
		SimulatorObject simObject = new SimulatorObject();
		databaseService.saveObject(simObject, new StoreObjectCallback());
	}

	@SuppressWarnings("deprecation")
	@UiHandler("addObject")
	void onAddObject(ClickEvent event){
	
		String objectName = name.getText();
		String impactDegree = impactFactor.getText();
		String objectEffect = effect.getText();
		String objectVolt = volt.getText();
		String objectLongitude = longtitude.getText();
		String objectLatitude = latitude.getText();
		String objectUsagePattern = usagePattern.getText();
		
		try
		{
			float floatEffect = Float.parseFloat(objectEffect);
			float floatVolt = Float.parseFloat(objectVolt);
			int intLongitude = Integer.parseInt(objectLongitude);
			int intLatitude = Integer.parseInt(objectLatitude);
			int intUsagePattern = Integer.parseInt(objectUsagePattern);
			int intImpactDegree = Integer.parseInt(impactDegree);
			
			SimObject newObject = new SimObject();
			newObject.name = objectName;
			newObject.effect = floatEffect;
			newObject.volt = floatVolt;
			newObject.longitude = intLongitude;
			newObject.latitude = intLatitude;
			newObject.usagePattern = intUsagePattern;
			newObject.impactDegree = intImpactDegree;
			
			
			
			if(simulatorObject.isEmpty)
			{
				
				simulatorObject.rootObject = newObject;
			}
			else
			{
				
				simulatorObject.rootObject.simulatorObjects.add(newObject);
			}
			
			simulatorObject.isEmpty = false;
			
			updateTree();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void updateTree()
	{
		tree.clear();
		
		CheckBox cb = new CheckBox(simulatorObject.rootObject.name);
		TreeItem rootItem = new TreeItem(cb);
	
		rootItem.addItem("Effect: "+simulatorObject.rootObject.effect);
		rootItem.addItem("Volt: "+simulatorObject.rootObject.volt);
		rootItem.addItem("Longitude: "+simulatorObject.rootObject.longitude);
		rootItem.addItem("Latitude: "+simulatorObject.rootObject.latitude);
		rootItem.addItem("Usagepattern: "+simulatorObject.rootObject.usagePattern);
		rootItem.addItem("Impact degree :"+simulatorObject.rootObject.impactDegree);
		
    	cb.setValue(true);
    	cb.addClickListener(new ClickListener()
    	{

			@Override
			public void onClick(Widget sender) {
				
				
			}
    		
    	});
    	
    	
    	
    	
    	//h� h�
    	Iterator<SimObject> iterator = simulatorObject.rootObject.simulatorObjects.iterator();
    	
    	while(iterator.hasNext())
    	{
    		SimObject entry = iterator.next();
    		
    		rootItem.addItem(addChildren(entry));
    	}
    	
    	tree.addItem(rootItem);
    	
    	initWidget(tree);
	}
	
	private TreeItem addChildren(SimObject simObject)
	{
		CheckBox cb = new CheckBox(simObject.name);
		TreeItem rootItem = new TreeItem(cb);
		rootItem.addItem("Effect: "+simObject.effect);
		rootItem.addItem("Volt: "+simObject.volt);
		rootItem.addItem("Longitude: "+simObject.longitude);
		rootItem.addItem("Latitude: "+simObject.latitude);
		rootItem.addItem("Usagepattern: "+simObject.usagePattern);
		
		
    	cb.setValue(true);
    	cb.addClickListener(new ClickListener()
    	{

			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	
    	//h� h�
    	Iterator<SimObject> iterator = simObject.simulatorObjects.iterator();
    	
    	if(iterator.hasNext())
    	{
    		SimObject entry = iterator.next();
    		
    		rootItem.addItem(addChildren(entry));
    	}
    	
    	return rootItem;
	}
	
	private class SimulatorObjectTree
	{
		public boolean isEmpty = true;
		public SimObject rootObject = new SimObject();
		public SimObject currentSelectedObject = rootObject;
	}
	
	private class SimObject
	{	
		public String name;
		public float impactDegree;
		public float effect;
		public float volt;
		public int longitude;
		public int latitude;
		public int usagePattern;
		
		ArrayList<SimObject> simulatorObjects = new ArrayList<SimObject>();
	}
}
