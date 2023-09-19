package com.baitap.model;

/**
 * @author Phuong Oanh
 */

public class Student extends Person {
    private String studentCode;
    private String school;
    private int startYear;
    private double gpa;
    private Rank rank;

    public Student() {
    }

    public Student(String studentCode, String school, int startYear, double gpa) {
        this.studentCode = studentCode;
        this.school = school;
        this.startYear = startYear;
        this.gpa = gpa;
        this.rank = getRank();
    }

    public Rank getRank() {
        if (getGpa() < 3) {
            this.rank = rank.KEM;
        } else if (getGpa() < 5) {
            this.rank = rank.YEU;
        } else if (getGpa() >= 5 && getGpa() < 6.5) {
            this.rank = rank.TB;
        } else if (getGpa() >= 6.5 && getGpa() < 7.5) {
            this.rank = rank.KHA;
        } else if (getGpa() >= 7.5 && getGpa() < 9) {
            this.rank = rank.GIOI;
        } else if (getGpa() >= 9) {
            this.rank = rank.XUAT_SAC;
        }
        return rank;
    }

    public Student(String name, String birthDate, String address, float height, float weight, String studentCode, String school, int startYear, double gpa) {
        super(name, birthDate, address, height, weight);
        this.studentCode = studentCode;
        this.school = school;
        this.startYear = startYear;
        this.gpa = gpa;
        this.rank = getRank();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return
                "Id=" + getId() +
                        ", BirthDate=" + getBirthDate() +
                        ", Name=" + getName() +
                        ", Address=" + getAddress() +
                        ", Height=" + getHeight() +
                        ", Weight=" + getWeight() +
                        ", Student code=" + getStudentCode() +
                        ", School=" + school +
                        ", StartYear=" + startYear +
                        ", Gpa=" + gpa +
                        ", Rank=" + rank;
    }
}
