package under.ground.staxparsing.ua;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import under.ground.components.ua.Car;
import under.ground.components.ua.Depo;
import under.ground.components.ua.Driver;
import under.ground.components.ua.Line;
import under.ground.components.ua.Passengers;
import under.ground.components.ua.Station;
import under.ground.components.ua.Train;
import under.ground.proces.ua.UndergroundProject;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

public class CorrectParsingStAX {

	private XmlPullParser xmlParser;

	public CorrectParsingStAX(String fileName) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			xmlParser = factory.newPullParser();
			xmlParser.setInput(new FileReader(fileName));
		} catch (XmlPullParserException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public UndergroundProject getInfoUnderground() {
		UndergroundProject under = null;
		Depo depo = null;
		Line line = null;
		Passengers passenger = null;
		Train train = null;
		Driver driver = null;
		Car car = null;
		//CarMain carmain = null;
		Station station = null;
		String tagName;
		int tagDepth;
		try {
			while (xmlParser.getEventType() != XmlPullParser.END_DOCUMENT) {
				tagName = xmlParser.getName();
				tagDepth = xmlParser.getDepth();

				switch (xmlParser.getEventType()) {

				case XmlPullParser.START_TAG:
					if (tagName.equals("UndergroundProject")) {
						// starting - creation of Line
						under = new UndergroundProject();
						break;
					}
					if (tagName.equals("Alllines") && tagDepth == 2) {
						// starting - creation of Line
						line = new Line();
						break;
					}
					if (tagName.equals("lineName") && tagDepth == 3) {
						// starting - creation of Line
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							line.setName(xmlParser.getText());
						}
						break;
					}
					if (tagName.equals("StationList") && tagDepth == 3) {
						// starting - creation of Line
						station = new Station();
						break;
					}
					if (tagName.equals("StationName") && tagDepth == 4) {
						// starting - creation of Line
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							station.setStationName(xmlParser.getText());
						}
						break;
					}
					if (tagName.equals("TransitStation") && tagDepth == 4) {
						// starting - creation of Line
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							station.setPeresadka(xmlParser.getText());
						}
						break;
					}
					if (tagName.equals("PassOnStation") && tagDepth == 4) {
						passenger = new Passengers();
						break;
					}
					if (tagName.equals("gender") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							passenger.setGender(xmlParser.getText());
						}
						break;
					}
					if (tagName.equals("age") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							passenger.setAge(Integer.parseInt(xmlParser.getText()));
						}
						break;
					}
					if (tagName.equals("Direction") && tagDepth == 3) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							line.setDirection(xmlParser.getText());
						}
						break;
					}
					if (tagName.equals("TrainList") && tagDepth == 3) {
						train = new Train();
						break;
					}
					if (tagName.equals("TrainName") && tagDepth == 4) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							train.setName(xmlParser.getText());
							break;
						}
					}

					if (tagName.equals("TrainCars") && tagDepth == 4) {
						car = new Car();
						break;
					}

					if (tagName.equals("CarName") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							car.setName(xmlParser.getText());
							break;
						}
					}
					if (tagName.equals("Doors") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							car.setDoors(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("Window") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							car.setWindow(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("Seat") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							car.setSeat(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("PassInCars") && tagDepth == 5) {
						passenger = new Passengers();
						break;
					}
					if (tagName.equals("gender") && tagDepth == 6) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							passenger.setGender(xmlParser.getText());
							break;
						}
					}
					if (tagName.equals("age") && tagDepth == 6) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							passenger.setAge(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("Driver") && tagDepth == 4) {
						driver = new Driver();
						break;
					}
					if (tagName.equals("DriverName") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							driver.setName(xmlParser.getText());
							break;
						}
					}
					if (tagName.equals("Age") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							driver.setAge(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("Experience") && tagDepth == 5) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							driver.setExperience(Integer.parseInt(xmlParser.getText()));
							break;
						}
					}
					if (tagName.equals("DepoMain") && tagDepth == 2) {
						depo = new Depo();
						break;
					}
					if (tagName.equals("DepoName") && tagDepth == 3) {
						xmlParser.next();
						if (xmlParser.getEventType() == XmlPullParser.TEXT) {
							depo.setName(xmlParser.getText());
							break;
						}
					}
					if (tagName.equals("DepoMain") && tagDepth == 2) {
						under.setDepoMain(depo);
					}
				case XmlPullParser.END_TAG:
					if (tagName.equals("Alllines") && tagDepth == 2) {
						under.getAlllines().add(line);
					}
					if (tagName.equals("StationList") && tagDepth == 3) {
						line.getStationsList().add(station);
					}
					if (tagName.equals("PassOnStation") && tagDepth == 4) {
						station.getPassOnStation().add(passenger);
					}
					if (tagName.equals("TrainList") && tagDepth == 3) {
						line.getTrainList().add(train);
					}
					if (tagName.equals("TrainCars") && tagDepth == 4) {
						if (car.getPassInCar().isEmpty()) {
							depo.getDepoCars().add(car);
						}
						else {
							train.getTrainCars().add(car);
						}
					}
					if (tagName.equals("PassInCars") && tagDepth == 5) {
						car.getPassInCar().add(passenger);
					}
					if (tagName.equals("Driver") && tagDepth == 4) {
						train.setTrainDriver(driver);
					}
					if (tagName.equals("DepoMain") && tagDepth == 2) {
						under.setDepoMain(depo);
					}
				default:
					break;
				}
				xmlParser.next();
			}
		} catch (XmlPullParserException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return under;
	}
}
