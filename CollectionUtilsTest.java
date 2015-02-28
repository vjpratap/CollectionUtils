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
	}
}