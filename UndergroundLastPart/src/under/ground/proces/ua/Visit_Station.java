package under.ground.proces.ua;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import under.ground.components.ua.Passengers;
import under.ground.components.ua.Station;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Visit_Station {

	@DatabaseField(foreign=true)
	private Station id;
		
	@DatabaseField(foreign=true)
	private Train_Moving_Line idd;
	
	@DatabaseField (foreign=true)
	private Passengers passIn;
	
	@DatabaseField (foreign=true)
	private Passengers passOut;
	
	public Visit_Station() {
		super();
	}
		
}
