package com.baitap.service;


import com.baitap.constant.CheckConstant;
import com.baitap.model.Rank;
import com.baitap.model.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Phuong Oanh
 */
public class StudentService {
    private Scanner scanner = new Scanner(System.in);
    private static final int MAX_STUDENTS = 100;
    private static Student[] studentArray = new Student[MAX_STUDENTS];
    private List<Student> students = new ArrayList<>();
    private int count;

    public StudentService() {
        fakeData();
    }

    public void fakeData() {
        studentArray[0] = new Student("Oanh", ("04-11-2003"), "Ha Noi", 150, 42,
                "SV1", "FPT", 2021, 8);
        studentArray[1] = new Student("Oanh2", ("04-11-2000"), "Ha Noi", 150, 42,
                "SV2", "FPT", 2021, 5.5);
        count += 2;
        students.add(studentArray[0]);
        students.add(studentArray[1]);
    }

    public void addStudent() {
        try {
            System.out.print("Nhập số lượng sv: ");
            int numToAdd = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numToAdd; i++) {
                String studentCode;
                boolean isStudentCodeExist;
                do {
                    studentCode = inputstudentCode();
                    isStudentCodeExist = isStudentCodeExist(studentCode);
                    if (isStudentCodeExist) {
                        System.out.println("Mã sinh viên đã tồn tại trong danh sách. Vui lòng nhập lại.");
                    }
                } while (isStudentCodeExist);

                String name = inputName();
                String birthDate = inputBirthDate();
                String address = inputAddress();
                float height = inputHeight();
                float weight = inputWeight();
                String School = inputSchool();
                int startYear = inputStartYear();
                double gpa = inputGPA();
                Student newStudent = new Student(
                        name, birthDate, address, height, weight, studentCode, School, startYear,
                        gpa
                );
                System.out.println(newStudent);
                studentArray[count] = newStudent;
                count++;
                students.add(newStudent);
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số");
        }
    }

    public boolean isStudentCodeExist(String studentCode) {
        for (Student student : studentArray) {
            if (student != null && student.getStudentCode().equals(studentCode)) {
                return true;
            }
        }
        return false;
    }


    public String inputName() {
        String name;
        do {
            name = getInputValue("Name");
        } while (!CheckConstant.isValidName(name));
        return name;
    }

    public String inputstudentCode() {
        String studentCode;
        do {
            studentCode = getInputValue("StudentCode");
        } while (!CheckConstant.isValidStudentCode(studentCode));
        return studentCode;
    }

    public float inputHeight() {
        float height;
        do {
            try {
                height = Float.parseFloat(getInputValue("Height"));
                if (height >= CheckConstant.MIN_HEIGHT && height <= CheckConstant.MAX_HEIGHT) {
                    return height;
                } else
                    System.out.println("Chiều cao từ 50 đến 300 cm");
            } catch (Exception e) {
                System.out.println("Chiều cao phải là số ");
            }
        } while (true);
    }

    public float inputWeight() {
        float weight;
        do {
            try {
                weight = Float.parseFloat(getInputValue("Weight"));
                if (weight >= CheckConstant.MIN_WEIGHT && weight <= CheckConstant.MAX_WEIGHT) {
                    return weight;
                } else
                    System.out.println("Cân nặng từ 5 đến 1000 kg");
            } catch (Exception e) {
                System.out.println("Cân nặng phải là số ");
            }
        } while (true);
    }

    public int inputStartYear() {
        int startYear;
        do {
            try {
                startYear = Integer.parseInt(getInputValue("Start year"));
                if (startYear >= CheckConstant.MIN_START_YEAR && startYear <= Year.now().getValue()) {
                    return startYear;
                } else {
                    System.out.println("Năm bắt đầu phải từ 1900 ");
                }
            } catch (Exception e) {
                System.out.println("Năm bắt đầu phải là số ");
            }
        } while (true);
    }

    public String inputSchool() {
        String school;
        do {
            school = getInputValue("School");
        } while (!CheckConstant.isValidSchool(school));
        return school;
    }


    public double inputGPA() {
        double gpa;
        do {
            try {
                gpa = Double.parseDouble(getInputValue("GPA"));
                if (gpa > CheckConstant.MIN_GPA && gpa <= CheckConstant.MAX_GPA) {
                    return gpa;
                } else
                    System.out.println("GPA từ 0-10");
            } catch (Exception e) {
                System.out.println("GPA phải là số ");
            }
        } while (true);
    }

    public String inputAddress() {
        String address;
        do {
            address = getInputValue("Address");
        } while (!CheckConstant.isValidAddress(address));
        return address;
    }

    public String inputBirthDate() {
        String birthDate;
        do {
            birthDate = getInputValue("Birth Date(dd-MM-yyyy)");
        } while (!CheckConstant.isValidDate(birthDate));
        return birthDate;
    }

    public String getInputValue(String msg) {
        System.out.printf("%s: ", msg);
        return scanner.nextLine();
    }

    public void displayStudent() {
        System.out.println("Danh sách sinh viên:");
        if (count == 0) {
            System.out.println("Không có sinh viên nào");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void searchStudentID() {
        System.out.print("Nhập Id để tìm kiếm: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            searchStudent(id);
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số");
            scanner.nextLine();
        }
    }

    public Student searchStudent(int id) {
        for (Student student : studentArray) {
            if (student != null && student.getId() == id) {
                System.out.println("Sinh viên cần tìm");
                System.out.print("ID: " + student.getId());
                System.out.print(", Name: " + student.getName());
                System.out.print(", Birth Date: " + student.getBirthDate());
                System.out.print(", Address: " + student.getAddress());
                System.out.print(", Height: " + student.getHeight());
                System.out.print(", Weight: " + student.getWeight());
                System.out.print(", Student code: " + student.getStudentCode());
                System.out.print(", School: " + student.getSchool());
                System.out.print(", Start year: " + student.getStartYear());
                System.out.print(", GPA: " + student.getGpa());
                System.out.print(", Rank: " + student.getRank());
                return student;
            }
        }
        System.out.println("Sinh viên có " + id + "không tìm thấy");
        return null;
    }

    public void updateStudent() {
        System.out.print("Nhập id svien cần update: ");
        int id = scanner.nextInt();
        Student updateStudent = searchStudent(id);
        if (updateStudent != null) {
            System.out.println();
            System.out.println("---------Thông tin cập nhật----------");
            System.out.println("1. Student code");
            System.out.println("2. School");
            System.out.println("3. Start year");
            System.out.println("4. GPA");
            System.out.println("5. BirthDate");
            System.out.println("6. Name");
            System.out.println("7. Address");
            System.out.println("8. Height");
            System.out.println("9. Weight");
            System.out.print("Chọn thông tin cần cập nhật: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    String newStudentCode;
                    boolean isExist;
                    do {
                        newStudentCode = inputstudentCode();
                        isExist = isStudentCodeExist(newStudentCode);
                        if (isExist) {
                            System.out.println("Mã sinh viên đã tồn tại trong danh sách. Vui lòng nhập lại.");
                        } else {
                            updateStudent.setStudentCode(newStudentCode);
                            System.out.println("Mã sinh viên đã được cập nhật.");
                            break;
                        }
                    } while (isExist);
                    break;
                case 2:
                    String newSchool = inputSchool();
                    updateStudent.setSchool(newSchool);
                    break;
                case 3:
                    Integer newStartYear = inputStartYear();
                    updateStudent.setStartYear(newStartYear);
                    break;
                case 4:
                    Double newGpa = inputGPA();
                    updateStudent.setGpa(newGpa);
                    updateStudent.getRank();
                    break;
                case 5:
                    String birthDate = inputBirthDate();
                    updateStudent.setBirthDate(birthDate);
                    break;
                case 6:
                    String newName = inputName();
                    updateStudent.setName(newName);
                    break;
                case 7:
                    String newAddress = inputAddress();
                    updateStudent.setAddress(newAddress);
                    break;
                case 8:
                    Float newHeight = inputHeight();
                    updateStudent.setHeight(newHeight);
                    break;
                case 9:
                    Float newWeight = inputWeight();
                    updateStudent.setWeight(newWeight);
                    break;
                default:
                    System.out.println("Chọn lại!!!.");
            }

            System.out.println("Cập nhật sinh viên:");
            System.out.println(updateStudent);
        } else {
            return;
        }
    }

    public void deleteStudent() {
        System.out.print("Nhập id sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int deleteIndex = -1;
        for (int i = 0; i < count; i++) {
            if (studentArray[i] != null && studentArray[i].getId() == id) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex != -1) {
            System.out.println("Xóa thành công!");
            for (int j = deleteIndex; j < count - 1; j++) {
                studentArray[j] = studentArray[j + 1];
            }
            students.remove(deleteIndex);
            studentArray[count - 1] = null;
            count--;
        } else {
            System.out.println("Sinh viên có " + id + " không tồn tại");
        }
    }

    public void phanTramHocLuc() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentList.add(studentArray[i]);
        }
        int totalStudents = studentList.size();
        Map<Rank, Double> rankPercentages = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankPercentages.put(rank, 0.0);
        }
        for (Student student : studentList) {
            Rank rank = student.getRank();
            double percentage = rankPercentages.get(rank) + 1;
            rankPercentages.put(rank, percentage);
        }
        List<Map.Entry<Rank, Double>> sortedRankPercentages = new ArrayList<>(rankPercentages.entrySet());
        sortedRankPercentages.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("Phần trăm học lực (từ cao xuống thấp):");
        for (Map.Entry<Rank, Double> entry : sortedRankPercentages) {
            Rank rank = entry.getKey();
            double percentage = (entry.getValue() / totalStudents) * 100;
            System.out.println(rank + ": " + formatter.format(percentage) + "%");
        }
    }

    public void phanTramDiemTrungBinh() {
        Map<Double, Integer> soLuongDiemTrungBinh = new HashMap<>();
        int tongSoSinhVien = 0;

        for (Student student : studentArray) {
            if (student != null) {
                tongSoSinhVien++;
                double diemTrungBinh = student.getGpa();
                soLuongDiemTrungBinh.put(diemTrungBinh, soLuongDiemTrungBinh.getOrDefault(diemTrungBinh, 0) + 1);
            }
        }

        System.out.println("Phần trăm điểm trung bình của các sinh viên:");
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        for (Map.Entry<Double, Integer> entry : soLuongDiemTrungBinh.entrySet()) {
            double diemTrungBinh = entry.getKey();
            int soLuong = entry.getValue();
            double phanTram = (double) soLuong / tongSoSinhVien * 100;
            System.out.println("GPA " + diemTrungBinh + ": " + decimalFormat.format(phanTram) + "%");
        }
    }

    public void hienThiTheoHocLuc(Rank hocLuc) {
        System.out.println("Danh sách sinh viên có học lực " + hocLuc + ":");

        for (Student student : studentArray) {
            if (student != null && student.getRank() == hocLuc) {
                System.out.println(student);
                System.out.println(" - Học Lực: " + student.getRank());
            }
        }
    }

    public void findTheoHocLuc() {
        String hocLucInput = getInputValue("Nhập học lực (YEU, KEM, TB, KHA, GIOI, XUAT_SAC)");
        try {
            Rank hocLuc = Rank.valueOf(hocLucInput.toUpperCase());
            hienThiTheoHocLuc(hocLuc);
        } catch (IllegalArgumentException e) {
            System.out.println("Học lực không hợp lệ.");
        }
    }

    public void saveStudentsToFile() {
        try {
            FileWriter myWriter = new FileWriter(CheckConstant.FILE_NAME);
            for (int i = 0; i < count; i++) {
                myWriter.write(studentArray[i].toString() + "\n");
            }
            myWriter.close();
            System.out.println("Dữ liệu sinh viên đã được lưu vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi lưu file");
            e.printStackTrace();
        }
    }
}

