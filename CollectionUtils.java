import java.util.*;

interface ListMapper<E>{
	E mapper(E element);
}

interface ListFilter{
	public boolean isGreaterThan5(int element);
}

class CollectionUtilsForInteger implements ListMapper<Integer>, ListFilter{
	public Integer mapper(Integer element){
		return element*5;
	}

	public boolean isGreaterThan5(int element){
		return element > 5;
	}
}

class CollectionUtilsForString implements ListMapper<String>{
	public String mapper(String element){
		return element.toUpperCase();
	}
}

public class CollectionUtils{
	public static<E> List<E> map(List<E> list, ListMapper<E> listMapper){
		List<E> result = new ArrayList<E>();
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