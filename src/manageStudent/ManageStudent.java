package manageStudent;

import java.util.*;

public class ManageStudent {
    ArrayList<Student> students = new ArrayList<>();

    public ManageStudent(ArrayList<Student> students) {
        this.students = students;
    }
    public Student input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên(Cxxxx[G|H|I|K]xx): ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh sinh viên: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();
        System.out.print("Nhập email sinh viên: ");
        String email = scanner.nextLine();
        System.out.print("Nhập điểm sinh viên: ");
        double score = scanner.nextDouble();

        return new Student(id, name, dateOfBirth, address, email, score);

    }
    public void add(Student student){
        students.add(input());
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
    public void editByName(String name){
        int index = checkByName(name);
        if (index == -1){
            System.out.println("Không có thông tin sinh viên cần sửa");
        }else
            students.set(index, input());
    }
    public void deleteByName(String name){
        Scanner scanner = new Scanner(System.in);
        if (checkByName(name)!=-1){
            System.out.println("Bạn có chắc chắn muốn xóa thông tin sinh viên "+ name+ " không? 1: có    2: không");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    students.remove(checkByName(name));
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
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equals(name)){
                arrayList.add(students.get(i));
            }
        }return arrayList;
    }
    public void sortByName(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int sort = o1.getName().compareTo(o2.getName());
                if (sort == 0){
                    return (int) (o1.getScore() - o2.getScore());
                }else
                    return sort;
            }
        });
    }
    public void menu(){
        System.out.println("==========Menu==========");
        System.out.println("1. Thêm 1 sinh viên");
        System.out.println("2. Sửa thông tin 1 sinh viên");
        System.out.println("3. Xóa thông tin 1 sinh viên");
        System.out.println("4. Tìm thông tin 1 sinh viên theo tên");
        System.out.println("5. Sắp xếp sinh viên theo tên");
        System.out.println("0. Thoát chương trình");
    }

}
