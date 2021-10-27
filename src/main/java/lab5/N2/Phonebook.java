package lab5.N2;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> _phonebook = new HashMap<>();

    public void set(String name, String tel){
        ArrayList<String> phonesOnName = new ArrayList<>();
        if(_phonebook.get(name) == null){
            phonesOnName.add(tel);
            _phonebook.put(name, phonesOnName);
        } else {
            phonesOnName = _phonebook.get(name);
            phonesOnName.add(tel);
            _phonebook.put(name, phonesOnName);
        }
    }

    public ArrayList<String> get(String name){
        return _phonebook.get(name);
    }
}
