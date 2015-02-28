import java.util.*;

interface ListMapper<E,K>{
	K mapper(E element);
}

interface ListFilter{
	public boolean isGreaterThan5(int element);
}

class CollectionUtilsForInteger implements ListMapper<Integer,Integer>, ListFilter{
	public Integer mapper(Integer element){
		return element*5;
	}

	public boolean isGreaterThan5(int element){
		return element > 5;
	}
}

class CollectionUtilsForString implements ListMapper<String,String>{
	public String mapper(String element){
		return element.toUpperCase();
	}
}

class CollectionUtilsForIntegerToString implements ListMapper<Integer, String>{
	public String mapper (Integer element){
		return "hello number " + element; 
	}
}

public class CollectionUtils{
	public static<E,K> List<K> map(List<E> list, ListMapper<E,K> listMapper){
		List<K> result = new ArrayList<K>();
		for(E element: list){
			result.add(listMapper.mapper(element));
		}
		return result;
	}

	public static List<Integer> filter(List<Integer> list, ListFilter listFilter){
		List<Integer> result = new ArrayList<Integer>();
		for(Integer element: list){
			if(listFilter.isGreaterThan5(element))
				result.add(element);
		}
		return result;
	}
}