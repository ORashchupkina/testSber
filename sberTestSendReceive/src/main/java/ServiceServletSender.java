import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/servlet")
public class ServiceServletSender extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    Producer sender;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        try {
            String element = request.getParameter("element");
            String value = request.getParameter("value");
            String json = "{element: \"" + element + "\","
                    + "element: \"" + element + "\","
                    + "date: \"" + new Date() + "\"}";
            sender.sendMessage(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}