package com.baitap.constant;


import com.baitap.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Phuong Oanh
 */

public class CheckConstant {
    public static final int MAX_NAME_LENGTH = 100;
    public static final int MAX_ADDRESS_LENGTH = 300;
    public static final float MIN_HEIGHT = 50;
    public static final float MAX_HEIGHT = 300;
    public static final int MIN_WEIGHT = 5;
    public static final int MAX_WEIGHT = 1000;
    public static final int STUDENT_CODE_LENGTH = 10;
    public static final int MAX_SCHOOL_LENGTH = 200;
    public static final int MIN_START_YEAR = 1900;
    public static final int MIN_GPA = 0;
    public static final int MAX_GPA = 10;
    public final static String FILE_NAME = "students.txt";

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên không được để trống");
            return false;
        } else if (name.length() >= MAX_NAME_LENGTH) {
            System.out.println("Tên không được vượt quá " + MAX_NAME_LENGTH + " kí tự");
            return false;
        } else if (name.matches(".*[^a-zA-Z\\s-\\p{IsLatin}].*")) {
            System.out.println("Tên không được chứa ký tự đặc biệt hoặc số ");
            return false;
        }
        return true;
    }

    public static boolean isValidStudentCode(String studentCode) {
        if (studentCode == null || studentCode.trim().isEmpty()) {
            System.out.println("Mã sv không được để trống");
            return false;
        } else if (studentCode.length() >= STUDENT_CODE_LENGTH) {
            System.out.println("Mã sv không được vượt quá " + STUDENT_CODE_LENGTH + " kí tự");
            return false;
        }
        return true;
    }


    public static boolean isValidDate(String dateOfBirth) {
        try {
            LocalDate dateOfBirthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate currentDate = LocalDate.now();
            if (dateOfBirthDate.isAfter(currentDate)) {
                System.out.println("Ngày sinh không được vượt quá ngày hiện tại");
                return false;
            } else if (dateOfBirthDate.getYear() <= 1900) {
                System.out.println("Ngày sinh phải bắt đầu từ năm 1900");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Ngày sinh không hợp lệ");
            return false;
        }

    }

    public static boolean isValidAddress(String address) {
        try {
            if (address == null || address.trim().isEmpty()) {
                System.out.println("Địa chỉ không được để trống");
                return false;
            } else if (address.length() >= MAX_ADDRESS_LENGTH) {
                System.out.println("Địa chỉ không được vượt quá " + MAX_ADDRESS_LENGTH + " kí tự");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Không đúng định dạng");
            return false;
        }

    }

    public static boolean isValidSchool(String school) {
        if (school == null || school.trim().isEmpty()) {
            System.out.println("Trường không được để trống");
            return false;
        } else if (school.length() >= MAX_SCHOOL_LENGTH) {
            System.out.println("Trường không được vượt quá " + MAX_SCHOOL_LENGTH + " kí tự");
            return false;
        }
        return true;
    }
}
