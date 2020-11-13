import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;

@ApplicationScoped
public class Producer {
    //получаем ресурсы сервера для отправки сообщений
    @Resource(name="jms/sberTestTool")
    private ConnectionFactory connectionFactory;

    @Resource(name="jms/SberTestTopic")
    private Destination destination;

    public void sendMessage(String enterString) {
        try (JMSContext context = connectionFactory.createContext()){
            context.createProducer().send(destination, enterString);
        } catch (JMSRuntimeException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        }
    }
}
