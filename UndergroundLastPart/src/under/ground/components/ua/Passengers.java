package under.ground.components.ua;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Passengers {

	public static int idiPassengerStat;

	@DatabaseField
	private String gender;

	@DatabaseField
	private int age;

	@DatabaseField(id = true)
	private int idiPassenger;

	@DatabaseField(foreign = true)
	private Car CarId;

	@DatabaseField(foreign = true)
	private Station StationId;

	public Passengers() {
		this.idiPassenger = idiPassengerStat;
		idiPassengerStat++;
	}

	public Passengers(String gender, int age) {
		super();
		this.gender = gender;
		this.age = age;
		this.idiPassenger = idiPassengerStat;
		idiPassengerStat++;
	};

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdiPassenger() {
		return idiPassenger;
	}

	public void setIdiPassenger(int idiPassenger) {
		this.idiPassenger = idiPassenger;
	}

	public Car getCarId() {
		return CarId;
	}

	public void setCarId(Car carId) {
		CarId = carId;
	}

	public Station getStationId() {
		return StationId;
	}

	public void setStationId(Station stationId) {
		StationId = stationId;
	}

	@Override
	public String toString() {
		return "\nPassengers [gender= " + gender + ", age= " + age + ", idiPassenger= " + idiPassenger + "]";
	}

}
