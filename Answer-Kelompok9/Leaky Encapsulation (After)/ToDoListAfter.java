package leaky_Encapsulation_Before;

import java.util.Vector;
import java.util.list;

public class ToDoList {
    private List<ToDo> list;

    public ToDoList() {
        list = new ArrayList<>();
    }

    public List<ToDo> getlist() {
        // Return a deep copy of the list
        List<ToDo> copyList = new ArrayList<>();
        for (ToDo toDo : list) {
            //Create a new ToDo object with the same name and add it to the copy list
            ToDo copyToDo = new ToDo(toDo.getName());
            copyList.add(copyToDo);
        }
        return copyList;
    }

    public ToDo getByName(String name) {
        for (ToDo toDo : list) {
            if(toDo.getName().equals(name)) {
                return toDo;
            } 
        }

        return null;
    }

    public void add(ToDo t) {
        list.add(t);
    }
}