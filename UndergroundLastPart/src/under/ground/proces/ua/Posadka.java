package under.ground.proces.ua;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import under.ground.components.ua.Car;
import under.ground.components.ua.Passengers;
import under.ground.components.ua.Station;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

public class Posadka implements Runnable {

	static CyclicBarrier Cyclic = new CyclicBarrier(5);
	private Station station;
	private Car car;

	public Posadka(Station station, Car car) {
		super();
		this.station = station;
		this.car = car;

	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while ((!station.getPassOnStation().isEmpty()) & (car.getPassInCar().size() < car.getSeat())) {
			Passengers a = station.getPassOnStation().remove(0);
			car.getPassInCar().add(a);
			try {
				Random rand = new Random();
				int al[] = { 30000, 3000, 4000, 5000, 6000 };
				Thread.sleep(al[rand.nextInt(al.length)]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Idi passengers = " + "[" + a.getIdiPassenger() + "]" + " idi Car = " + "["
					+ car.getIdiCar() + "]" + " size = " + car.getPassInCar().size());
		}
		try {
			Cyclic.await();
			System.out.println("vse pasashyry seli v vagon" + "idi Car" + car.getIdiCar());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
