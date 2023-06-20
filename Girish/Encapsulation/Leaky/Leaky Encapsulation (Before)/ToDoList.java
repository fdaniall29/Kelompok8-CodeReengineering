package leaky_Encapsulation_Before;

import java.util.Vector;

public class ToDoList {
    //....
    private Vector<ToDo> list;

    public ToDoList() {
        list = new Vector<>();
    }

    public Vector<ToDo> getlist() {
        // shallow copy -> deep copy
        return list;
    }

    public ToDo getByName(String name) {
        for (ToDo toDo : list) {
            if(toDo.getName().equals(name)) return toDo;
        }

        return null;
    }

    public void add(ToDo t) {
        list.add(t);
    }
    
    //....
}

