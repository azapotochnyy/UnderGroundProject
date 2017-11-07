package under.ground.start.ua;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Random;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.CyclicBarrier;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.PriorityBlockingQueue;

//import javax.swing.text.StyledEditorKit.StyledTextAction;

//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserException;
//import org.xmlpull.v1.XmlPullParserFactory;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
//import com.j256.ormlite.table.TableUtils;

import under.ground.components.ua.Car;
import under.ground.components.ua.CarMain;
import under.ground.components.ua.Depo;
import under.ground.components.ua.Driver;
import under.ground.components.ua.Escalator;
import under.ground.components.ua.Line;
//import under.ground.components.ua.Lobby;
import under.ground.components.ua.Passengers;
import under.ground.components.ua.Station;
import under.ground.components.ua.StationsNames;
import under.ground.components.ua.Train;
import under.ground.proces.ua.Posadka;
import under.ground.proces.ua.UndergroundProject;
import under.ground.staxparsing.ua.CorrectParsingStAX;

public class UndegroundMain {

	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		// TODO Auto-generated method stub

		// Connection to DB
		ConnectionSource connection;
		String login = "unduser";
		String password = "pass1";
		String UrlAddres = "jdbc:mysql://localhost/UNDERGROUND?" + "user=" + login + "&password=" + password;

		Dao<Car, Integer> CarDao;
		Dao<CarMain, Integer> CarMainDao;
		Dao<Driver, Integer> DriverDao;
		Dao<Passengers, Integer> PassengersDao;
		Dao<Line, String> LineDao;
		Dao<Station, StationsNames> StationDao;
		Dao<Train, Integer> TrainDao;
		Depo depf = null;

		try {
			connection = new JdbcConnectionSource(UrlAddres);
			CarDao = DaoManager.createDao(connection, Car.class);
			// TableUtils.createTable(CarDao);
			// CarMainDao.create();
			// TableUtils.dropTable(CarDao,true);
			CarMainDao = DaoManager.createDao(connection, CarMain.class);
			// TableUtils.createTable(CarMainDao);
			// CarMainDao.create();
			// TableUtils.dropTable(CarMainDao,true);
			DriverDao = DaoManager.createDao(connection, Driver.class);
			// TableUtils.createTable(DriverDao);
			// CarMainDao.create();
			// TableUtils.dropTable(DriverDao,true);
			LineDao = DaoManager.createDao(connection, Line.class);
			// TableUtils.createTable(DriverDao);
			// CarMainDao.create();
			// TableUtils.dropTable(DriverDao,true);
			StationDao = DaoManager.createDao(connection, Station.class);
			// TableUtils.createTable(StationDao);
			// TableUtils.dropTable(StationDao,true);
			TrainDao = DaoManager.createDao(connection, Train.class);
			// TableUtils.createTable(TrainDao);
			// TableUtils.dropTable(TrainDao,true);
			// TrainDao.create();
			PassengersDao = DaoManager.createDao(connection, Passengers.class);
			// TableUtils.createTable(PassengersDao);
			// TableUtils.dropTable(PassengersDao,true);

			// Car in Depo Creator using CarInDepoCreator from Depo.class
			Car g = new Car("gg", 25, 18, 35);
			CarMain h = new CarMain("hh", 25, 18, 24, true);
			depf = new Depo("Lukjanovka");
			depf.CarInDepoCreator(g, h);
			// System.out.println(depf.getDepoCars());

			// Train in Depo Creator using TrainInDepoCreator from Depo class
			depf.TrainInDepoCreator();

			Driver f = new Driver("Pedro", 18, 25);
			Driver ff = new Driver("Jorhe", 19, 26);
			Driver fff = new Driver("Pedro", 41, 27);

			// Comparator for DriverQueue
			Comparator<Driver> comparator = new Comparator<Driver>() {
				@Override
				public int compare(Driver arg0, Driver arg1) {
					// TODO Auto-generated method stub
					if (arg0.getExperience() > arg1.getExperience()) {
						return -1;
					}
					if (arg0.getExperience() < arg1.getExperience()) {
						return 1;
					}
					return 0;
				}
			};

			// BlockingQueue for Drivers
			/*
			 * BlockingQueue<Driver> DriverQueue = new
			 * PriorityBlockingQueue<Driver>(10, comparator);
			 * DriverQueue.add(f); DriverQueue.add(ff); DriverQueue.add(fff);
			 */

			// We put Drivers into a Train and then we change theirs experience
			// using method changeExperiance() from Driver.class
			/*
			 * Iterator<Train> itorTrain = depf.getDepoTrains().iterator();
			 */
			// We create collection for Threads
			/*
			 * LinkedList<Thread> allThreads = new LinkedList<>(); while
			 * (itorTrain.hasNext()) { Train a = itorTrain.next(); Driver d =
			 * DriverQueue.take();
			 */
			// We create a Thread for getting the Drivers in a Train
			/*
			 * Thread driverInTrain = new Thread(new Runnable() {
			 * 
			 * @Override public void run() { a.setTrainDriver(d);
			 * d.changeExperiance(); try { Thread.sleep(2000); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * 
			 * System.out.println("\ndriver " + d + " is going " + a.hashCode());
			 * 
			 * try {DriverQueue.put(d); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); } } });
			 */
			// Starting and adding the Treads into the Collection (allThreads)
			/*
			 * driverInTrain.start(); 
			 * allThreads.add(driverInTrain); // }
			 * }
			 * for(Thread th: allThreads){ try { th.join(); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * }
			 * 
			 */
			//We create a Underground and all components
			UndergroundProject under = new UndergroundProject();
			Line red1 = new Line("RED", "SVJATOSHYNSKO_BROVARSKA_R");
			Line green1 = new Line("GREEN", "SYREZJKO_PECHERSKA_G");
			Line blue1 = new Line("BLUE", "KURENJOVSKO_CHERVONOARMEISKA_B");
			under.getAlllines().add(red1);
			under.getAlllines().add(green1);
			under.getAlllines().add(blue1);
			StationsNames[] few = StationsNames.values();
			String aptr;
			for (int i = 0; i <= 15; i++) {
				if ((i == 7) | (i == 8)) {
					aptr = "" + few[i];
					Station station = new Station(aptr, blue1, "true");
					// StationDao.create(station);
					blue1.getStationsList().add(station);
				} else {
					aptr = "" + few[i];
					Station station = new Station(aptr, blue1, "false");
					// StationDao.create(station);
					blue1.getStationsList().add(station);
				}
			}
			for (int i = 16; i <= 33; i++) {
				if ((i == 23) | (i == 24)) {
					aptr = "" + few[i];
					Station station = new Station(aptr, red1, "true");
					// StationDao.create(station);
					red1.getStationsList().add(station);
				} else {
					aptr = "" + few[i];
					Station station = new Station(aptr, red1, "false");
					// StationDao.create(station);
					red1.getStationsList().add(station);
				}
			}

			for (int i = 34; i <= 49; i++) {
				if ((i == 45) | (i == 46)) {
					aptr = "" + few[i];
					Station station = new Station(aptr, green1, "true");
					// StationDao.create(station);
					green1.getStationsList().add(station);
				} else {
					aptr = "" + few[i];
					Station station = new Station(aptr, green1, "false");
					// StationDao.create(station);
					green1.getStationsList().add(station);
				}
			}

			Iterator<Line> alllines = under.getAlllines().iterator();
			while (alllines.hasNext()) {
				Line a = alllines.next();
				Iterator<Station> linesStations = a.getStationsList().iterator();
				while (linesStations.hasNext()) {
					Station s = linesStations.next();
					Escalator first = new Escalator(s, s.getLobby());
					Escalator second = new Escalator(s, s.getLobby());
					Escalator third = new Escalator(s, s.getLobby());
					Thread passToLobby = new Thread(s.getLobby());
					Thread passToEscalatorOne = new Thread(first);
					Thread passToEscalatorTwo = new Thread(second);
					Thread passToEscalatorThree = new Thread(third);
					passToLobby.start();
					passToEscalatorOne.start();
					passToEscalatorTwo.start();
					passToEscalatorThree.start();
				}
			}

			// Taking the trains from Depo on the Lines red,green,blue
			Iterator<Train> itorTrainOnLine = depf.getDepoTrains().iterator();
			while (itorTrainOnLine.hasNext()) {
				Train a = itorTrainOnLine.next();
				red1.getTrainList().add(a);
				if (itorTrainOnLine.hasNext() == true) {
					a = itorTrainOnLine.next();
					green1.getTrainList().add(a);
				}
				if (itorTrainOnLine.hasNext() == true) {
					a = itorTrainOnLine.next();
					blue1.getTrainList().add(a);
				}
			}

			//If we want to see all we have on different lines of the Underground
			System.out.println("---------------------------------");
			// System.out.println(red1);
			System.out.println("---------------------------------");
			// System.out.println(green1);
			System.out.println("---------------------------------");
			// System.out.println(blue1);
			System.out.println("---------------------------------");

			// The train is moving on the red line and passengers are going in/out
			// the cars

			Iterator<Train> itorTrainOnLineOnStation = red1.getTrainList().iterator();
			while (itorTrainOnLineOnStation.hasNext()) {
				Train a = itorTrainOnLineOnStation.next();
				Iterator<Station> itorStationOfLine = red1.getStationsList().iterator();
				while (itorStationOfLine.hasNext()) {
					Station b = itorStationOfLine.next();
					System.out.println(
							"Station Name" + b.getStationName() + " [before] " + b.getPassOnStation().size() + " []");
					Thread oneposadka = new Thread(new Posadka(b, a.getTrainCars().get(0)));
					Thread twoposadka = new Thread(new Posadka(b, a.getTrainCars().get(1)));
					Thread threeposadka = new Thread(new Posadka(b, a.getTrainCars().get(2)));
					Thread fourposadka = new Thread(new Posadka(b, a.getTrainCars().get(3)));
					Thread fiveposadka = new Thread(new Posadka(b, a.getTrainCars().get(4)));
					oneposadka.start();
					twoposadka.start();
					threeposadka.start();
					fourposadka.start();
					fiveposadka.start();
				}
			}

			// The train is moving on the blue line and passengers are going
			// in/out the cars
			Iterator<Train> itorTrainOnLineOnStation2 = blue1.getTrainList().iterator();
			while (itorTrainOnLineOnStation.hasNext()) {
				Train a = itorTrainOnLineOnStation.next();
				Iterator<Station> itorStationOfLine = blue1.getStationsList().iterator();
				while (itorStationOfLine.hasNext()) {
					Station b = itorStationOfLine.next();
					System.out.println(
							"Station Name" + b.getStationName() + " [before] " + b.getPassOnStation().size() + " []");
					Thread oneposadka = new Thread(new Posadka(b, a.getTrainCars().get(0)));
					Thread twoposadka = new Thread(new Posadka(b, a.getTrainCars().get(1)));
					Thread threeposadka = new Thread(new Posadka(b, a.getTrainCars().get(2)));
					Thread fourposadka = new Thread(new Posadka(b, a.getTrainCars().get(3)));
					Thread fiveposadka = new Thread(new Posadka(b, a.getTrainCars().get(4)));
					oneposadka.start();
					twoposadka.start();
					threeposadka.start();
					fourposadka.start();
					fiveposadka.start();
				}
			}

			// The train is moving on the green line and passengers are going in/out
			// the cars
			Iterator<Train> itorTrainOnLineOnStation3 = green1.getTrainList().iterator();
			while (itorTrainOnLineOnStation.hasNext()) {
				Train a = itorTrainOnLineOnStation.next();
				Iterator<Station> itorStationOfLine = green1.getStationsList().iterator();
				while (itorStationOfLine.hasNext()) {
					Station b = itorStationOfLine.next();
					System.out.println(
							"Station Name" + b.getStationName() + " [before] " + b.getPassOnStation().size() + " []");
					Thread oneposadka = new Thread(new Posadka(b, a.getTrainCars().get(0)));
					Thread twoposadka = new Thread(new Posadka(b, a.getTrainCars().get(1)));
					Thread threeposadka = new Thread(new Posadka(b, a.getTrainCars().get(2)));
					Thread fourposadka = new Thread(new Posadka(b, a.getTrainCars().get(3)));
					Thread fiveposadka = new Thread(new Posadka(b, a.getTrainCars().get(4)));
					oneposadka.start();
					twoposadka.start();
					threeposadka.start();
					fourposadka.start();
					fiveposadka.start();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Parsing StAX
		// Location addres of xml File
		String a = "C://Users//Админ//Desktop//Infopulse2//UnderGroundLastDataBaseXMLparsing//src//UndergroundXMLFile.xml";

		CorrectParsingStAX corr = new CorrectParsingStAX(a);
		UndergroundProject undernew = corr.getInfoUnderground();
		//Open to Print parsing XML File UnderGroundXMLFile.vml
		//System.out.println(undernew);

		System.out.println("---------------------------------");

	}
}
