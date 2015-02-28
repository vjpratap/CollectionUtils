import java.util.*;

interface ListMapper{
	public int multiplyby5(int element);
}

interface ListFilter{
	public boolean isGreaterThan5(int element);
}

// class ListMapper{
// 	public int multiplyby5(int element){
// 		return element*5;
// 	}
// }

// class ListFilter{
// 	public boolean isGreaterThan5(int element){
// 		return element > 5;
// 	}
// }


class  CollectionUtilsFuncs implements ListMapper, ListFilter{
	public int multiplyby5(int element){
		return element*5;
	}

	public boolean isGreaterThan5(int element){
		return element > 5;
	}
}

public class CollectionUtils{
	public static List<Integer> map(List<Integer> list, ListMapper listMapper){
		List<Integer> result = new ArrayList<Integer>();
		for(Integer element: list){
			result.add(listMapper.multiplyby5(element));
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