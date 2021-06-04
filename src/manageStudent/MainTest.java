package manageStudent;

public class MainTest {
    public static void main(String[] args) {
        ManageStudent ms = new ManageStudent();
        ms.display(ms.students);
        ms.add(ms.input());
        ms.display(ms.students);

    }
}
