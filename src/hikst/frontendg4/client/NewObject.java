package hikst.frontendg4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;

public class NewObject extends Composite implements HasText {

	ObjectMenu panel;
	
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
	
	@UiHandler("impactFactor")
	void onUserClickimpactFactor(ClickEvent event) {
		impactFactor.setText("");
	}
	@UiHandler("effect")
	void onUserClickeffect(ClickEvent event) {
		effect.setText("");
	}
	@UiHandler("volt")
	void onUserClickvolt(ClickEvent event) {
		volt.setText("");
	}
	@UiHandler("name")
	void onUserClickname(ClickEvent event) {
		name.setText("");
	}
	@UiHandler("longtitude")
	void onUserClicklongtitude(ClickEvent event) {
		longtitude.setText("");
	}
	@UiHandler("latitude")
	void onUserClicklatitude(ClickEvent event) {
		latitude.setText("");
	}
	@UiHandler("usagePattern")
	void onUserClickusagePattern(ClickEvent event) {
		usagePattern.setText("");
	}

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
}