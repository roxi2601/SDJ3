package main.java.userExercise.test;

import main.java.userExercise.User;
import main.java.userExercise.UserDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.rmi.RemoteException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class UserTest {
	private UserDAO userDAO;
	private User firstUser;
	private User secondUser;

	@Before
	public void setUp() throws Exception {
		URL wsdl = new URL("http://localhost:8090/branch?wsdl");
		QName name = new QName("http://userExercise.java.main/", "RemoteBranchService");
		Service service = Service.create(wsdl, name);
		userDAO = service.getPort(UserDAO.class);
		firstUser = userDAO.create(144,"roxi260111@gmail.com","kotkot");
		assertNotNull(firstUser);
		secondUser = userDAO.create(15555555,"julia","tosiatosia");
	}
	
	@After
	public void tearDown() {
		if (firstUser != null) userDAO.delete(firstUser);
		if (secondUser != null) userDAO.delete(secondUser);
	}
	
	@Test
	public void test() throws RemoteException {
		String EXPECTED_EMAIL = "roxi";
		User expectedUser = new User(14444, EXPECTED_EMAIL,"tosia");
		User actualUser = userDAO.read(EXPECTED_EMAIL);
		assertSame(expectedUser,actualUser);
	}
}
