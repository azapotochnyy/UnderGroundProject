package under.ground.components.ua;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

import java.util.LinkedList;
import java.util.Random;

public class Escalator implements Runnable {

	public static int escIdiStat = 0;
	private LinkedList<Passengers> passOnEscalator;
	private Station stationName;
	private Lobby lobbyname;
	private int escIdi;

	public Escalator(Station stationName, Lobby lobby) {
		super();
		this.passOnEscalator = new LinkedList<>();
		this.stationName = stationName;
		this.lobbyname = lobby;
		this.escIdi = escIdiStat;
		escIdiStat++;
	}

	public Lobby getLobbyname() {
		return lobbyname;
	}

	public void setLobbyname(Lobby lobbyname) {
		this.lobbyname = lobbyname;
	}

	public LinkedList<Passengers> getPassOnEscalator() {
		return passOnEscalator;
	}

	public void setPassOnEscalator(LinkedList<Passengers> passOnEscalator) {
		this.passOnEscalator = passOnEscalator;
	}

	public Station getStationName() {
		return stationName;
	}

	public void setStationName(Station stationName) {
		this.stationName = stationName;
	}

	@Override
	public void run() {

		while (true) {
			Passengers pas = null;
			// Block a station
			lobbyname.getLock().lock();
			// If there are no peaple on a lobby - wait
			while (lobbyname.getPassOnLobby().isEmpty()) {
				try {
					lobbyname.getCondi().await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if (!lobbyname.getPassOnLobby().isEmpty()) {
					pas = lobbyname.getPassOnLobby().poll();
					this.passOnEscalator.add(pas);
				}
			} finally {
				lobbyname.getLock().unlock();
			}
			try {
				Random rand = new Random();
				int a[] = { 30000, 3000, 4000, 5000, 6000 };
				Thread.sleep(a[rand.nextInt(a.length)]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!this.passOnEscalator.isEmpty()) {
				stationName.getPassOnStation().add(this.passOnEscalator.poll());
				System.out.println("Escalator idi = " + this.escIdi + " Passenger idi= " + pas.getIdiPassenger()
						+ " is on Station name " + stationName.getStationName());
			}
			stationName.getPassOnStation().add(pas);
		}
	}
}
