public class Student implements Person{

    private String id;
    private String nume;
    private Specializare specializare;
    private int anStudiu;
    private int medie;

    public Student(String id, String nume, Specializare specializare, int anStudiu, int medie){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID invalid");
        }
        if(nume == null || nume.isBlank()){
            throw new IllegalArgumentException("nume invalid");
        }
        if(anStudiu < 1){
            throw new IllegalArgumentException("an de studiu invalid");
        }
        if(medie < 0){
            throw new IllegalArgumentException("medie invalida");
        }

        this.id = id;
        this.nume = nume;
        this.specializare = specializare;
        this.anStudiu = anStudiu;
        this.medie = medie;
    }


    @Override
    public String getId() {
        return id;
    }

    public String getNume(){
        return nume;
    }

    public Specializare getSpecializare(){
        return specializare;
    }

    public int getAnStudiu(){
        return anStudiu;
    }

    public int getMedie(){
        return medie;
    }
    @Override
    public String format() {
        return id + " | " + nume + " | " + specializare + " | " + anStudiu + " | " + medie;
    }
}
