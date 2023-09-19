package com.baitap;

import com.baitap.service.StudentService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            StudentService service = new StudentService();
            while (true) {
                System.out.println("----------MENU-------------");
                System.out.println("1.Thêm sinh viên");
                System.out.println("2.Hiển thị danh sách sv");
                System.out.println("3.Tìm sv theo id");
                System.out.println("4.Cập nhật sv");
                System.out.println("5.Xóa sv");
                System.out.println("6.Hiển thị % học lực");
                System.out.println("7.Hiển thị % điểm trung bình");
                System.out.println("8.Tìm sinh viên theo học lực");
                System.out.println("9.Lưu danh sách sinh viên");
                System.out.println("0.Thoát");
                System.out.println("----------------------------");
                System.out.print("Vui lòng chọn chức năng:");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        service.addStudent();
                        break;
                    case 2:
                        service.displayStudent();
                        break;
                    case 3:
                        service.searchStudentID();
                        break;
                    case 4:
                        service.updateStudent();
                        break;
                    case 5:
                        service.deleteStudent();
                        break;
                    case 6:
                        service.phanTramHocLuc();
                        break;
                    case 7:
                        service.phanTramDiemTrungBinh();
                        break;
                    case 8:
                        service.findTheoHocLuc();
                        break;
                    case 9:
                        service.saveStudentsToFile();
                        break;
                    case 0:
                        System.out.println("Hẹn gặp lại!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng chọn chức năng!");
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}



