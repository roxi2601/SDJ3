package main.java.userExercise.data;


import main.java.userExercise.User;
import main.java.userExercise.UserDAO;

import javax.jws.WebService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@WebService(endpointInterface = "main.java.userExercise.UserDAO", serviceName="UserService")
public class UserDAOService implements UserDAO {
    private static final long serialVersionUID = 1L;
    private DatabaseHelper<User> helper;

    public UserDAOService(String jdbcURL, String username, String password) {
        helper = new DatabaseHelper<>(jdbcURL, username, password);
    }
    @Override
    public User create(int id, String email, String password)  {
        final List<Integer> keys = helper.executeUpdateWithGeneratedKeys("INSERT INTO UserExercise(id, email, password) VALUES (?, ?, ?)",
                id, email,password);
        return read(email);
    }

    @Override
    public User read(String email) {
        return helper.mapSingle(new UserMapper(),"SELECT * FROM UserExercise WHERE email =? ",
                email);
    }


    //new class!
    public static class UserMapper implements DataMapper<User> {
        @Override
        public User create(ResultSet rs) throws SQLException {
            User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
            return new User(user.getId(), user.getEmail(),user.getPassword());
        }
    }
///////////////////////////////

    @Override
    public void update(User user)  {
        helper.executeUpdate("UPDATE UserExercise SET password = ? WHERE id =? AND email=? ",
                user.getId(), user.getEmail(), user.getPassword());
    }

    @Override
    public void delete(User user)  {
        helper.executeUpdate("DELETE * FROM UserExercise WHERE id =? AND email=? AND password=?", user.getId(),
                user.getEmail(),user.getPassword());
    }
}
