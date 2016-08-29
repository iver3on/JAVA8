import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Iver3on
 * @date 2016年8月29日
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person(34,"zzz");
		Person p2 = new Person(29,"zvvz");
		Person p3 = new Person(18,"zaz");
		Person p4 = new Person(31,"zsz");
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Filter<Person> f = new Filter<>();
		FilterProcessor<Person> fp = new FilterProcessor<Person>() {			
			@Override
			public boolean process(Person t) {
				 if(t.getAge()>=30){
					 System.out.println(t.getName());
					 return true; 
				 }else{
					  return false; 
				 }        
			}
		};
		List<Person> l= f.filter(list, fp);
		for(Person p:l){
			System.out.println(p.getName());
		}
	}

}
