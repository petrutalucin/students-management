import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StudentService {
    private List<Person> persons = new ArrayList<>();
    private HashMap<String, Person> map = new HashMap<>();

    public void add(Person person) throws DuplicateStudentException{
        if(map.containsKey(person.getId())){
            throw new DuplicateStudentException("student duplicat");
        }
        persons.add(person);
        map.put(person.getId(), person);
    }

    public void remove(String id) throws StudentNotFoundException{
        Person person = map.get(id);
        if(person == null){
            throw new StudentNotFoundException("persoana nu este gasita");
        }
        persons.remove(person);
        map.remove(id);
    }

    public List<Person>sortByNume(){
        List<Person>sorted = new ArrayList<>();
        Collections.sort(sorted, new SortByNameComparator());
        return sorted;
    }

    public List<Person>sortByMedie(){
        List<Person>sorted = new ArrayList<>();
        Collections.sort(sorted, new SortByAnComparator());
        return sorted;
    }

    public List<Person>searchByName(String nume){
        List<Person>result = new ArrayList<>();

        for(Person student : persons){
            Student stu = (Student) student;
            if(stu.getNume().toLowerCase().contains(nume.toLowerCase())){
                result.add(student);
            }
        }
        return result;
    }
    public List<Person> getAll() {
        return new ArrayList<>(persons);
    }

}
