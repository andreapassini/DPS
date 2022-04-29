package UniversityEx;

import it.ewlab.researcher.InfoStudentOuterClass.InfoStudent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Server Working . . .");

        Socket s = serverSocket.accept();

        InfoStudent infoStudent = InfoStudent.parseFrom(s.getInputStream());

        System.out.println(infoStudent);
    }


}
