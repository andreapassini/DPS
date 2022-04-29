package UniversityEx;

import it.ewlab.researcher.ResearcherOuterClass.InfoStudent;

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
                        .addExams(InfoStudent.Exam.newBuilder()
                                .setExamName("DPS")
                                .setMark(18)
                                .setDate("Today").build())
                        .addExams(InfoStudent.Exam.newBuilder()
                                .setExamName("OGD")
                                .setMark(27)
                                .setDate("LastYear").build())
                        .build();

        Researcher r =
                Researcher.newBuilder()
                        .setName("Gabriele")
                        .setSurname("Civitarese")
                        .setType(Researcher.ResearcherType.POSTDOC)
                        .addPaper(Researcher.Paper.newBuilder().setTitle("Activity Recognition")
                                .setYear(2014).build())
                        .addPaper(Researcher.Paper.newBuilder().setTitle("Activity Recognition Again")
                                .setYear(2015).build())
                        .build();

        infoStudent.writeTo(s.getOutputStream());

        s.close();
    }
}
