package Ex5UniversityJSON;

public class StudentInfo {
    String name;
    String surname;
    int yearOfBirth;
    PlaceOfResidence placeOfResidence;
    Exam exams[];

    public StudentInfo(String name, String surname, int yearOfBirth, PlaceOfResidence place, Exam exams[]){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.placeOfResidence  = place;
        this.exams = exams;
    }
}



