package Ex5UniversityJSON;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ClientEx5 {
    public static void main(String argv[]) throws Exception{
        String sentece;
        String modifiedSentence;
        String response;

        int portNumber;
        String address;


        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        address = "localhost";

        portNumber = 6789;

        //client socket init
        Socket clientSocket = new Socket(address, portNumber);

        // output stream towards
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket init
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Name: ");
        String name = inFromUser.readLine();

        System.out.println("Surname: ");
        String surname = inFromUser.readLine();

        System.out.println("Year of Birth: ");
        int yearOfBirth = Integer.parseInt(inFromUser.readLine());

        System.out.println("Place of Residence: ");

        System.out.println("Nation: ");
        String nation = inFromUser.readLine();

        System.out.println("City: ");
        String city = inFromUser.readLine();

        System.out.println("Address: ");
        String localAddress = inFromUser.readLine();

        PlaceOfResidence placeOfResidence = new PlaceOfResidence(nation, city, localAddress);

        System.out.println("\n Now exams ");
        System.out.println("Press 0 to send your info");

        int procede = 1;

        // Use an ARRAYLIST PLS
        ArrayList<Exam> exams= new ArrayList<Exam>();

        int i = 0;

        while (procede != 0){

            System.out.println("Exam Name: ");
            String examName = inFromUser.readLine();

            System.out.println("Mark: ");
            String mark = inFromUser.readLine();

            System.out.println("Date: ");
            String date = inFromUser.readLine();

            Exam exam = new Exam(examName, mark, date);

            exams.add(exam);

            i++;

            System.out.println("Press 0 to send your info");
            procede = Integer.parseInt(inFromUser.readLine());
        }

        StudentInfo studentInfo = new StudentInfo(
                name,
                surname,
                yearOfBirth,
                placeOfResidence,
                exams
        );

        Gson gson = new Gson();
        String userJson = gson.toJson(studentInfo);


        // send the line to the server
        outToServer.writeBytes(userJson + "\n");
        System.out.println("Request sent . . .");

        // read the response from the server
        response = inFromServer.readLine();
        System.out.println("FROM SERVER: " + response);

        clientSocket.close();
    }

}
