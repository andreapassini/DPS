package UniversityEx;


import it.ewlab.researcher.InfoStudentOuterClass.InfoStudent;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 9999);

        InfoStudent infoStudent =
                InfoStudent.newBuilder()
                        .setName("Andrea")
                        .setSurname("P")
                        .setYearOfBirth("11/01/1998")
                        .setPlaceOfResidence(InfoStudent.PlaceOfResidence.newBuilder()
                                .setState("Italy")
                                .setCity("Brescia")
                                .setAddress("Via C")
                                .build())
                        .addExam(InfoStudent.Exam.newBuilder()
                                .setExamName("DPS")
                                .setMark(18)
                                .setDate("Today").build())
                        .addExam(InfoStudent.Exam.newBuilder()
                                .setExamName("OGD")
                                .setMark(27)
                                .setDate("LastYear").build())
                        .build();


        infoStudent.writeTo(s.getOutputStream());

        s.close();
    }
}
