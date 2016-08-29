import java.util.List;

/**
 * 
 */

/**
 * @author Iver3on
 * @date 2016年8月29日
 */
public class Person {
	int age;
	
	
	/**
	 * @param age
	 * @param name
	 */
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
}
