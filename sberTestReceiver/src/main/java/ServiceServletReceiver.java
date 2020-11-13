import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceServletReceiver extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {
        try {
            String mode = request.getParameter("mode");

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (!mode.equalsIgnoreCase("receive")) {
                return;
            }
            String BR = "<br />";
            out.print("receive messages :" + BR);
            if (Listener.messages.size() > 0) {
                for (int i = 0; i < Listener.messages.size(); i++) {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(Listener.messages.get(i));
                    JSONObject jsonObj = (JSONObject) obj;
                    String element = jsonObj.get("element").toString();
                    String value = jsonObj.get("value").toString();
                    String date = jsonObj.get("date").toString();

                    out.print("&mdash; " + element + " " + value + " " + date + BR);
                }
                Listener.messages.clear();

            }
            out.close();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}