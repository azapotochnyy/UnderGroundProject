package under.ground.components.ua;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

public class Lobby implements Runnable {

	private LinkedList<Passengers> passOnLobby;
	private Lock lock = new ReentrantLock();
	private Condition condi = lock.newCondition();

	public Lobby() {
		super();
		this.passOnLobby = new LinkedList<>();
	}

	public Condition getCondi() {
		return condi;
	}

	public void setCondi(Condition condi) {
		this.condi = condi;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public LinkedList<Passengers> getPassOnLobby() {
		return passOnLobby;
	}

	public void setPassOnLobby(LinkedList<Passengers> passOnLobby) {
		this.passOnLobby = passOnLobby;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			getLock().lock();
			try {
				Passengers a = new Passengers();
				getPassOnLobby().add(a);
				getCondi().signalAll();
			} finally {
				getLock().unlock();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
