package under.ground.proces.ua;

import java.util.LinkedList;

import under.ground.components.ua.Depo;
import under.ground.components.ua.Line;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

public class UndergroundProject {

	private LinkedList<Line> alllines;
	private Depo depoMain;

	public UndergroundProject() {
		this.alllines = new LinkedList<>();
	}

	public UndergroundProject(Depo depoMain) {
		super();
		this.alllines = new LinkedList<>();
		this.depoMain = depoMain;
	}

	public LinkedList<Line> getAlllines() {
		return alllines;
	}

	public void setAlllines(LinkedList<Line> alllines) {
		this.alllines = alllines;
	}

	public Depo getDepoMain() {
		return depoMain;
	}

	public void setDepoMain(Depo depoMain) {
		this.depoMain = depoMain;
	}

	@Override
	public String toString() {
		return "UndergroundProject [alllines=" + alllines + ", depoMain=" + depoMain + "]";
	}

}
