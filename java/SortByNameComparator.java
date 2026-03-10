import java.util.Comparator;

public class SortByNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(!(o1 instanceof Student) || !(o2 instanceof Student)) {
            return 0;
        }
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getNume().compareToIgnoreCase(s2.getNume());
    }
}
