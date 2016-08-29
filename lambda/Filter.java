import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Iver3on
 * @date 2016年8月29日
 */
public class Filter<T>{
	
	List<T> filter(List<T> list, FilterProcessor filterProcessor){
	    List<T> result = new ArrayList<T>();
	    for(T t : list){
	        if(filterProcessor.process(t)){
	        	 result.add(t);
	        }else
	        	continue;
	    }
	    return result;
	}
	
}
