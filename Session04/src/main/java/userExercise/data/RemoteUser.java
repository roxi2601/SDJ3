package main.java.userExercise.data;

import main.java.userExercise.Head;
import main.java.userExercise.UserDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteUser extends UnicastRemoteObject implements Head {
        private static final long serialVersionUID = 1L;
        private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
        private static final String USERNAME = "postgres";
        private static final String PASSWORD = "Roksanka2601";


        private UserDAOService userDAOService;


        public RemoteUser() throws RemoteException {
            userDAOService = new UserDAOService(JDBC_URL, USERNAME, PASSWORD);
        }
        @Override
        public  UserDAO getUserDAO()
        {
                return userDAOService;
        }
}