package manageStudent;

import java.util.Scanner;

public class Main {
    public static String FILE_NAME = "src//listSV.csv";
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        ManageFile manageFile = new ManageFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("List sinh viên");
        manageStudent.display(manageStudent.students);

        while (true){
            manageStudent.menu();
            System.out.println("Nhập lựa chọn");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Nhập thông tin sinh viên muốn thêm");
                    manageStudent.add(manageStudent.input());
                    manageStudent.display(manageStudent.students);
                    break;
                case 2:
                    manageStudent.display(manageStudent.students);
                    break;
                case 3:
                    System.out.println("Nhập id sinh viên muốn sửa");
                    String id = scanner.nextLine();
                    manageStudent.editByID(id);
                    manageStudent.display(manageStudent.students);
                    break;
                case 4:
                    System.out.println("Nhập id sinh viên muốn xóa");
                    String id2 = scanner.nextLine();
                    manageStudent.deleteByID(id2);
                    manageStudent.display(manageStudent.students);
                case 5:
                    System.out.println("Nhập lựa chọn tìm kiếm: 1.Theo mã  2.Theo tên 3.Theo khoảng điểm");
                    int choice2;
                    choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2){
                        case 1:
                            System.out.println("Nhập ID sinh viên muốn tìm kiếm");
                            String idFind;
                            idFind = scanner.nextLine();
                            if (manageStudent.searchByID(idFind)==null){
                                System.out.println("Không có thông tin sinh viên cần tìm");
                            }else
                                System.out.println(manageStudent.searchByID(idFind).toString());
                            break;
                        case 2:
                            System.out.println("Nhập tên sinh viên muốn tìm kiếm");
                            String name;
                            name = scanner.nextLine();
                            if (manageStudent.searchByName(name)==null){
                                System.out.println("Không có thông tin sinh viên cần tìm");
                            }else
                                System.out.println(manageStudent.searchByName(name));
                            break;
                        case 3:
                            System.out.println("Nhập khoảng điểm cần tìm");
                            System.out.print("Nhập điểm thấp nhất: ");
                            double scoreMin = scanner.nextDouble();
                            System.out.print("Nhập điểm cao nhất: ");
                            double scoreMax = scanner.nextDouble();
                            System.out.println(manageStudent.SearchByScore(scoreMax, scoreMin));
                            break;
                        default:
                            System.out.println("Nhập lại lựa chọn");
                    }
                default:
                    System.out.println("Nhập lại lựa chọn");
            }
        }
    }
}
