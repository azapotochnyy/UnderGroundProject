package under.ground.components.ua;

import java.util.LinkedList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 *
 */

@DatabaseTable
public class Car {

	public static int idiCarstat;
	
	@DatabaseField(columnName = "producer")
	private String name;

	@DatabaseField
	private int doors;

	@DatabaseField
	private int window;

	private LinkedList<Passengers> passInCar;

	@DatabaseField
	private int seat;

	@DatabaseField(id = true)
	private int idiCar;

	@DatabaseField(foreign = true)
	private Train Carfortrain;

	public Car(String name, int doors, int window, int seat) {
		super();
		this.name = name;
		this.passInCar = new LinkedList<>();
		this.doors = doors;
		this.window = window;
		this.seat = seat;
		this.idiCar = idiCarstat;
		idiCarstat++;
	}

	public Car() {
		this.passInCar = new LinkedList<>();
		// TODO Auto-generated constructor stub
	}

	//Method to clone a Car by using a constructor
	public Car clone() throws CloneNotSupportedException {
		Car cloned = (Car) super.clone();
		return cloned;
	}

	public LinkedList<Passengers> getPassInCar() {
		return passInCar;
	}

	public void setPassInCar(LinkedList<Passengers> passInCar) {
		this.passInCar = passInCar;
	}

	public Train getCarfortrain() {
		return Carfortrain;
	}

	public void setCarfortrain(Train carfortrain) {
		Carfortrain = carfortrain;
	}
	
	public int getIdiCar() {
		return idiCar;
	}

	public void setIdiCar(int idiCar) {
		this.idiCar = idiCar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]" + "[doors=" + doors + "]" + "[window=" + window + "]" + "[seat=" + seat + "]"
				+ "IDI" + idiCar + " passInCar =  " + passInCar + "\r\n";
	}
}
