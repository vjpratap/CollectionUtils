import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionUtilsTest{

	@Test
	public void map_will_perform_given_operation_for_each_element_n_the_list(){
		List<Integer> list = new ArrayList<Integer>();
		ListMapper listMapper = new ListMapper();
		for (int i = 0;i < 5;i++) {
			list.add(i);
		}
		List<Integer> mappedList = CollectionUtils.map(list,listMapper);
		assertEquals((Integer)0,mappedList.get(0));
		assertEquals((Integer)5,mappedList.get(1));
		assertEquals((Integer)10,mappedList.get(2));
		assertEquals((Integer)20,mappedList.get(4));
		assertEquals(5, mappedList.size());
	}

	@Test
	public void test_that_function_filter_works_for_integer(){
		List<Integer> list = new ArrayList<Integer>();
		ListFilter listFilter = new ListFilter();
		list.add(6);
		list.add(9);
		list.add(0);
		list.add(5);
		List<Integer> filteredList = CollectionUtils.filter(list,listFilter);
		assertEquals((Integer)6,filteredList.get(0));
		assertEquals((Integer)9,filteredList.get(1));
		assertEquals(2,filteredList.size());
	}
}