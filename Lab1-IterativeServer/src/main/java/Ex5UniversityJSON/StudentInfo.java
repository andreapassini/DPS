package Ex5UniversityJSON;

import java.util.ArrayList;

public class StudentInfo {
    String name;
    String surname;
    int yearOfBirth;
    PlaceOfResidence placeOfResidence;
    ArrayList<Exam> exams;

    public StudentInfo(String name, String surname, int yearOfBirth, PlaceOfResidence place, ArrayList<Exam> exams){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.placeOfResidence  = place;
        this.exams = exams;
    }
}



