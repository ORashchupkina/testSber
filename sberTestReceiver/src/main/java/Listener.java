import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServlet;
import java.util.LinkedList;
import java.util.List;

@MessageDriven(
        //имя topic, на который подписан бин
        mappedName = "jms/SberTestTopic",
        name = "SberTestTopic")
public class Listener extends HttpServlet implements MessageListener {
    public static List<String> messages = new LinkedList<>();

    //метод, вызываемый при получении нового сообщения
    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage) msg;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
            System.out.println("FROM MDB - client type IS " + message.getStringProperty("clientType"));
            //считываем  само сообщение
            System.out.println("FROM MDB - payload  IS" + message.getText());

            messages.add(message.getText());

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
