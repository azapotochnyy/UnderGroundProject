package under.ground.components.ua;

import java.util.ArrayList;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Train {

	public static int idi = 0;

	@DatabaseField
	private String name;

	private ArrayList<Car> trainCars;

	@DatabaseField(foreign = true)
	private Driver trainDriver;

	@DatabaseField(canBeNull = false, id = true)
	private int iditrain;

	@DatabaseField(foreign = true)
	private Line lineName;

	public Train() {
		super();
		trainCars = new ArrayList<>();
	}

	public Train(String name) {
		super();
		this.name = name;
		this.trainCars = new ArrayList<>();
		this.iditrain = idi;
		idi++;
	}

	public Line getLineID() {
		return lineName;
	}

	public void setLineID(Line lineName) {
		this.lineName = lineName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Car> getTrainCars() {
		return trainCars;
	}

	public void setTrainCars(ArrayList<Car> trainCars) {
		this.trainCars = trainCars;
	}

	public Driver getTrainDriver() {
		return trainDriver;
	}

	public void setTrainDriver(Driver trainDriver) {
		this.trainDriver = trainDriver;
	}

	public int getIditrain() {
		return iditrain;
	}

	@Override
	public String toString() {
		return "Train [name=" + name + " Cars =" + trainCars + ", trainDriver=" + trainDriver + "]\n";
	}

}
