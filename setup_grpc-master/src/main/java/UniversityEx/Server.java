package UniversityEx;

import it.ewlab.researcher.ResearcherOuterClass.Researcher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(9999);

        Socket s = serverSocket.accept();

        InforStudent inforStudent = InforStudent.parseFrom(s.getInputStream());

        System.out.println(inforStudent);
    }


}
