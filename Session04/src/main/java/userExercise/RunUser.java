package main.java.userExercise;

import main.java.userExercise.data.RemoteUser;

import javax.xml.ws.Endpoint;

public class RunUser {
    public static void main(String[] args) throws Exception {
        RemoteUser user = new RemoteUser();
        Endpoint.publish("http://localhost:8080/user", user.getUserDAO());

    }
}
