package leaky_Encapsulation_Before;

import java.util.Vector;

public class ToDoListTest {
	    void test() {
	        ToDoList td = new ToDoList();

	        td.add(new ToDo("a"));
	        assert(td.getByName("a") != null);

	        List<ToDo> list = td.getList();
            list.get(0).setName("b")

	        assert(td.getByName("b") != null);

	    }
}
