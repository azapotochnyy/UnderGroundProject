package under.ground.components.ua;

import java.util.Random;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author A.Zapotochnyy
 * 
 */

@DatabaseTable
public class Driver {
	@DatabaseField
	private String name;

	@DatabaseField
	private int age;

	@DatabaseField
	private int experience;

	@DatabaseField(id = true)
	private int idiDrivers;
	public static int idiDriverStat;

	public Driver() {
	}

	public Driver(String name, int age, int experience) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.idiDrivers = idiDriverStat;
		idiDriverStat++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getIdiDrivers() {
		return idiDrivers;
	}

	public void setIdiDrivers(int idiDrivers) {
		this.idiDrivers = idiDrivers;
	}

	public void changeExperiance() {
		int a;
		Random rand = new Random();
		a = rand.nextInt(30);
		this.experience = this.experience + a;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", experience=" + experience + "]/n";
	}
}
