package under.ground.components.ua;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

public class Depo {

	private String name;
	private ArrayList<Car> depoCars;
	private ArrayList<Train> depoTrains;

	public Depo(String name) {
		super();
		this.name = name;
		this.depoCars = new ArrayList<>();
		this.depoTrains = new ArrayList<>();
	}

	public Depo() {
		this.depoCars = new ArrayList<>();
		this.depoTrains = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Car> getDepoCars() {
		return depoCars;
	}

	public void setDepoCars(ArrayList<Car> depoCars) {
		this.depoCars = depoCars;
	}

	public ArrayList<Train> getDepoTrains() {
		return depoTrains;
	}

	public void setDepoTrains(ArrayList<Train> depoTrains) {
		this.depoTrains = depoTrains;
	}

	public void CarInDepoCreator(Car one, CarMain two) {
		for (int i = 0; i < 1000; i++) {
			Random rand = new Random();
			if (rand.nextInt(100) < 30) {
				two = new CarMain("Hundaj", 28, 35, 16, true);
				this.depoCars.add(two);
			} else {
				one = new Car("Krjukovka", 30, 35, 18);
				this.depoCars.add(one);
			}
		}
	}

	/*
	 * A train size is 5 Cars the 1st is a CarMain the 2,3,4th are the Cars and
	 * thelastOne is a CarMain. That's why we use count in this method;
	 */
	public void TrainInDepoCreator() {
		Iterator<Car> itor = this.depoCars.iterator();
		Train tr = new Train("Jakamura");
		int count = 0;
		while (itor.hasNext()) {
			if (itor.next() != null) {
				Car f = itor.next();
				if (f instanceof CarMain) {
					if (count == 0) {
						tr.getTrainCars().add(count, f);
						count++;
					}
					if (count == 4) {
						tr.getTrainCars().add(count, f);
						count = 0;
					}
				} else {
					switch (count) {
					case 1:
						tr.getTrainCars().add(count, f);
						count++;
						break;
					case 2:
						tr.getTrainCars().add(count, f);
						count++;
						break;
					case 3:
						tr.getTrainCars().add(count, f);
						count++;
						break;
					default:
						break;
					}
				}
				if (tr.getTrainCars().size() == 5) {
					this.depoTrains.add(tr);
					tr = new Train("Hjundaj");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Depo [name=" + name + ", depoCars=" + depoCars + ", depoTrains=" + depoTrains + "]\n";
	}
}
