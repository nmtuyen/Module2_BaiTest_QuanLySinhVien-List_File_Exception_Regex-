package manageStudent;

import java.time.LocalDate;
import java.util.*;

public class ManageStudent {
    ArrayList<Student> students = new ArrayList<>();

    public ManageStudent(ArrayList<Student> students) {
        this.students = students;
    }
    public ManageStudent(){
        students = new ArrayList<>();
        students.add(new Student("C0321H01", "Chương", "12-05-1994", "HN", "abc.ds@codegym.vn", 7.5));
        students.add(new Student("C0321H02", "Phong", "09-05-2000", "TH", "def.ds@codegym.vn", 7.5));
        students.add(new Student("C0321H03", "Tú", "12-08-1995", "HN", "a.sd@codegym.vn", 7.5));
//        String id, String name, String dateOfBirth, String address, String email, double score
    }
    public Student input(){
        Scanner scanner = new Scanner(System.in);

        // Nhập ID và kiểm tra ID
        String id ;
        do {
            System.out.println("Nhập ID sinh viên(Cxxxx[G|H|I|K]xx): ");
            id = scanner.nextLine();
        }while (!InformationRegex.validateID(id));

        // Nhập tên
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        // Nhập ngày sinh và kiểm tra ngày sinh
        String dateOfBirth;
        do {
            System.out.print("Nhập ngày sinh sinh viên(dd-mm-yyyy): ");
            dateOfBirth = scanner.nextLine();
        }while (!InformationRegex.validateDate(dateOfBirth));

        System.out.print("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        String email;
        do {
            System.out.print("Nhập email sinh viên: ");
            email = scanner.nextLine();
        }while (!InformationRegex.validateEmail(email));
        System.out.print("Nhập điểm sinh viên: ");
        double score = scanner.nextDouble();

        return new Student(id, name, dateOfBirth, address, email, score);

    }
    public void add(Student student){
        students.add(student);

    }
    public void display(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
        System.out.println("---------------------------------");
    }
    public int checkByName(String name){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public int checkByID(String id){
        for (int i = 0; i< students.size(); i++){
            if (students.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void editByID(String id){
        int index = checkByID(id);
        if (index == -1){
            System.out.println("Không có thông tin sinh viên cần sửa");
        }else
            students.set(index, input());
    }

    public void deleteByID(String id){
        Scanner scanner = new Scanner(System.in);
        if (checkByID(id)!=-1){
            System.out.println("Bạn có chắc chắn muốn xóa thông tin sinh viên "+ id + " không? 1: có   2: không");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    students.remove(checkByID(id));
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
        else
            System.out.println("Không có thông tin sinh viên muốn xóa");
    }

    public ArrayList<Student> searchByName(String name){
        ArrayList<Student> arrayName = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equals(name)){
                arrayName.add(students.get(i));
            }else
                return null;
        }return arrayName;
    }

    public ArrayList<Student> searchByID(String id){
        ArrayList<Student> listID = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equals(id)){
                listID.add(students.get(i));
            }
        }
        return listID;
    }

    public ArrayList<Student> SearchByScore(double scoreMAx, double scoreMin){
        ArrayList<Student> listScore = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập khoảng điểm cần tìm kiếm");
//        System.out.print("Nhập điểm thấp nhất: ");
//        scoreMin = scanner.nextDouble();
//        System.out.print("Nhập điểm cao nhất: ");
//        scoreMAx = scanner.nextDouble();
        if (scoreMin>=scoreMAx){
            System.out.println("Khoảng điểm bạn nhập không tồn tại");
        }else {
            for (int i = 0; i < students.size(); i++){
                if (students.get(i).getScore()>=scoreMin && students.get(i).getScore()<=scoreMAx){
                    listScore.add(students.get(i));
                }
            }
        }
        return listScore;

    }
    public void sortByScore(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if ((int) (o1.getScore()- o2.getScore())==0){
                    int sx =o1.getName().compareTo(o2.getName());
                }
                return (int) (o1.getScore()- o2.getScore());
            }
        });
    }
    public void sortByAge(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    public void menu(){
        System.out.println("==========Menu==========");
        System.out.println("1. Thêm 1 sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Cập nhật thông tin sinh viên");
        System.out.println("4. Xóa thông tin sinh viên");
        System.out.println("5. Tìm kiếm thông tin sinh viên");
        System.out.println("6. Sắp xếp danh sách sinh viên");
        System.out.println("0. Thoát chương trình");
    }

}
