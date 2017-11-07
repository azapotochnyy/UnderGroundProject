package under.ground.components.ua;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class CarMain extends Car {

	@DatabaseField
	private boolean cabin;

	public CarMain(String name, int doors, int window, int seat, boolean cabin) {
		super(name, doors, window, seat);
		this.cabin = cabin;
	}

	public CarMain() {
	}

	// Method to clone a CarMain by using a constructor
	public CarMain clone() throws CloneNotSupportedException {
		CarMain cloned = (CarMain) super.clone();
		return cloned;
	}

	public boolean getCabin() {
		return cabin;
	}

	public void setCabin(boolean cabin) {
		this.cabin = cabin;
	}

	@Override
	public String toString() {
		return "CarMain [cabin=" + cabin + "]" + "[" + "[name=" + getName() + "]" + "[doors=" + getDoors() + "]"
				+ "[window=" + getWindow() + "]" + "[seat=" + getSeat() + "]" + "]" + "IDI" + getIdiCar() + "\r\n";
	}

}
