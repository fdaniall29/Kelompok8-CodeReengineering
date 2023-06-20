package leaky_Encapsulation_Before;

import java.util.Vector;

public class ToDoListTest {
	    void test() {
	        ToDoList td = new ToDoList();

	        // Vector<ToDo> list = td.getlist(); //(belakangn)

	        td.add(new ToDo("a"));
	        assert(td.getByName("a") != null);

	        Vector<ToDo> list = td.getlist();
	        list.elementAt(0).setName ("b");

	        assert(td.getByName("b") != null);

	    }

	

}
