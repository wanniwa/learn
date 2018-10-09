package 手写服务器.demo4.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class ParseXml {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1 获得解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2 从解析工厂拿到解析器
        SAXParser parser = factory.newSAXParser();
        PersonHandler personHandler = new PersonHandler();
        //3 加载文档 Document注册处理器
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("手写服务器/demo4/xml/person.xml"),personHandler);

        List<Person> persons = personHandler.getPersons();
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
