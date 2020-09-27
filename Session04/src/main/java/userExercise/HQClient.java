package main.java.userExercise;



import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HQClient implements Head {
    private String baseURL;
    private UserDAO userDAO;

    public HQClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public HQClient() {
        this("http://localhost:8080/");
    }

    private<T> T createServiceClient(String path, String serviceName, Class<T> targetClass) {
        try {
            URL wsdl = new URL(baseURL + path + "?wsdl");
            QName name = new QName("http://userExercise.java.main/", serviceName);
            Service service = Service.create(wsdl, name);
            return service.getPort(targetClass);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  UserDAO getUserDAO() {
        return userDAO;
    }
}
