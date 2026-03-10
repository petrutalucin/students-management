import java.util.Comparator;

public class SortByAnComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(!(o1 instanceof Student) || !(o2 instanceof Student)) {
            return 0;
        }
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return Integer.compare(s1.getMedie(), s2.getMedie());
    }
}
