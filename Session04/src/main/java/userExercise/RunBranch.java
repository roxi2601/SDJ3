package main.java.userExercise;



import javax.xml.ws.Endpoint;

public class RunBranch {
    public static void main(String[] args) {
        Head hq = new HQClient();
        RemoteBranch branch = new RemoteBranch(1234, hq);
        Endpoint.publish("http://localhost:8090/branch", branch);
    }
}
