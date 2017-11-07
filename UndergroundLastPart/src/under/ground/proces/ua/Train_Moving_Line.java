package under.ground.proces.ua;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import under.ground.components.ua.Driver;
import under.ground.components.ua.Station;
import under.ground.components.ua.Train;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Train_Moving_Line {

	public static int idMovingstat = 0;
	
	@DatabaseField(id = true)
	private int idMoving;

	@DatabaseField(foreign = true)
	private Driver driver;

	@DatabaseField(foreign = true)
	private Train train;

	@DatabaseField(foreign = true)
	private Station station;
	
	public Train_Moving_Line() {
	}

	public Train_Moving_Line(Driver driver, Train train, Station station) {
		super();
		this.idMoving = idMovingstat;
		this.driver = driver;
		this.train = train;
		this.station = station;
		idMovingstat++;
	}

	public int getIdMoving() {
		return idMoving;
	}

	public void setIdMoving(int idMoving) {
		this.idMoving = idMoving;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}
	
}
