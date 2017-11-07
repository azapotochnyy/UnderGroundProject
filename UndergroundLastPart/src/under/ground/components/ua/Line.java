package under.ground.components.ua;

import java.util.LinkedList;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Line {

	public static final String LINE_FIELD_NAME = "name";

	@DatabaseField(id = true)
	private String name;

	private LinkedList<Station> stationsList;

	@DatabaseField
	private String direction;

	private LinkedList<Train> TrainList;
	
	public Line() {
		this.stationsList = new LinkedList<>();
		this.TrainList = new LinkedList<>();
	}
	
	public Line(String name, String direction) {
		super();
		this.name = name;
		this.direction = direction;
		this.stationsList = new LinkedList<>();
		this.TrainList = new LinkedList<>();
		}

	public LinkedList<Train> getTrainList() {
		return TrainList;
	}

	public void setTrainList(LinkedList<Train> trainList) {
		TrainList = trainList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public LinkedList<Station> getStationsList() {
		return stationsList;
	}

	public void setStationsList(LinkedList<Station> stationsList) {
		this.stationsList = stationsList;
	}

	@Override
	public String toString() {
		return "Line [name=" + name + ", stationsList=" + stationsList + ", direction=" + direction + ", TrainList="
				+ TrainList + "]\n";
	}
}
