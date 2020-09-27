package main.java.userExercise;


import javax.jws.WebService;

@WebService(endpointInterface = "main.java.userExercise.UserDAO")
public class RemoteBranch implements UserDAO {
    private static final long serialVersionUID = 1;
    private int regNumber;
    private UserDAO userDAO;

    public RemoteBranch(int regNumber, Head hq) {
        this.regNumber = regNumber;
        this.userDAO = hq.getUserDAO();
    }


    @Override
    public User create(int id, String email, String password) {
        return userDAO.create(id, email, password);
    }

    @Override
    public User read(String email) {
        return userDAO.read(email);
    }
    @Override
    public void update(User password) {
        userDAO.update(password);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
