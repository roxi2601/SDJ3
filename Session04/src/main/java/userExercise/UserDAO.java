package main.java.userExercise;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface UserDAO {
    @WebMethod
    User create(int id, String email, String password);
    @WebMethod
    User read(String email);
    @WebMethod
    void update(User password);
    @WebMethod
    void delete(User user);
}
