package under.ground.components.ua;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Station {

	@DatabaseField(id = true)
	private String StationName;

	@DatabaseField(columnName = "peresadochna")
	private String peresadka;

	@DatabaseField(columnName = "Line_Name", foreign = true)
	private Line line;

	private Lobby lobby;
	private Lock loc = new ReentrantLock();
	private Condition condi = loc.newCondition();
	private List<Passengers> passOnStation;

	public Station() {
		this.passOnStation = new LinkedList<>();
	}

	public Station(String stationName, Line line, String peresadka) {
		super();
		StationName = stationName;
		this.line = line;
		this.peresadka = peresadka;
		this.passOnStation = PassengersCreation();
		this.lobby = new Lobby();

	}

	public Lock getLoc() {
		return loc;
	}

	public void setLoc(Lock loc) {
		this.loc = loc;
	}

	public Condition getCondi() {
		return condi;
	}

	public void setCondi(Condition condi) {
		this.condi = condi;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public Line getNameLine() {
		return line;
	}

	public void setNameLine(Line line) {
		this.line = line;
	}

	public String isPeresadka() {
		return peresadka;
	}

	public void setPeresadka(String peresadka) {
		this.peresadka = peresadka;
	}

	public List<Passengers> getPassOnStation() {
		return passOnStation;
	}

	public void setPassOnStation(LinkedList<Passengers> passOnStation) {
		this.passOnStation = passOnStation;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Lobby getLobby() {
		return lobby;
	}

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public List<Passengers> PassengersCreation() {
		List<Passengers> pass = Collections.synchronizedList(new LinkedList<Passengers>());

		// createPassengers on Station method (when there are no lobby) 
		/*
		 * Random rand1 = new Random(); int a = rand1.nextInt(1000); for (int i
		 * = 0; i < a; i++) { String gender[] = { "male", "female" }; Random
		 * rand2 = new Random(); String gend =
		 * gender[rand2.nextInt(gender.length)]; int age = rand2.nextInt(100);
		 * if (age == 0) { age++; } Passengers pasenger = new Passengers(gend,
		 * age); pass.add(pasenger); }
		 */
		return pass;
	}
	
	@Override
	public String toString() {
		return "Station [StationName=" + StationName + ", peresadka=" + peresadka + " passOnStation = " + passOnStation
				+ "]\n";
	}
}
