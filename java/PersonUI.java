import javax.swing.*;
import java.awt.*;

public class PersonUI extends JFrame {

    private JTextField IdField, NumeField, MedieField, AnStudiuField;
    private JComboBox<Specializare> specializareBox;
    private JTextArea area;

    private final StudentService service = new StudentService();

    public PersonUI() {
        setTitle("Studenti");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- INPUT PANEL --------
        JPanel input = new JPanel(new GridLayout(5, 2));

        IdField = new JTextField();
        NumeField = new JTextField();
        MedieField = new JTextField();
        AnStudiuField = new JTextField();

        specializareBox = new JComboBox<>(Specializare.values());

        input.add(new JLabel("ID"));
        input.add(IdField);
        input.add(new JLabel("Nume"));
        input.add(NumeField);
        input.add(new JLabel("Medie"));
        input.add(MedieField);
        input.add(new JLabel("An studiu"));
        input.add(AnStudiuField);
        input.add(new JLabel("Specializare"));
        input.add(specializareBox);

        add(input, BorderLayout.NORTH);

        // -------- TEXT AREA --------
        area = new JTextArea();
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);

        // -------- BUTTONS --------
        JPanel buttons = new JPanel();

        JButton addBtn = new JButton("Adauga");
        addBtn.addActionListener(e -> addStudent());

        JButton deleteBtn = new JButton("Sterge");
        deleteBtn.addActionListener(e -> stergereStudent());

        buttons.add(addBtn);
        buttons.add(deleteBtn);

        add(buttons, BorderLayout.SOUTH);
    }

    // -------- ADD --------
    private void addStudent() {
        try {
            int anStudiu = Integer.parseInt(AnStudiuField.getText().trim());
            int medie = Integer.parseInt(MedieField.getText().trim());

            Specializare spec = (Specializare) specializareBox.getSelectedItem();

            Student s = new Student(
                    IdField.getText().trim(),
                    NumeField.getText().trim(),
                    spec,
                    anStudiu,
                    medie
            );

            service.add(s);
            refresh();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Eroare",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // -------- DELETE --------
    private void stergereStudent() {
        try {
            String id = IdField.getText().trim();

            if (id.isEmpty()) {
                throw new IllegalArgumentException("ID-ul este gol");
            }

            service.remove(id);

            JOptionPane.showMessageDialog(this,
                    "Student șters cu succes");

            refresh();

        } catch (StudentNotFoundException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Eroare",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // -------- REFRESH --------
    private void refresh() {
        area.setText("");
        for (Person p : service.getAll()) {
            area.append(p.toString() + "\n");
        }

    }

    public static void main(String[] args) {
        new PersonUI().setVisible(true);
    }
}
