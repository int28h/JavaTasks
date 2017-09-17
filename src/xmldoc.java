//Второй тест (пример 2 в описании задания ниже) данное решение не проходит.
//Кроме того, не соблюдается формат вывода - отступы отсутствуют.

/**
 * Вам дан XML-документ в следующем формате:
 * 1) корневым элементом документа является элемент с именем 'projects';
 * 2) элемент 'projects' содержит один или несколько элементов 'project' 
 * с единственным атрибутом 'name';
 * 3) каждый элемент 'project' содержит один или несколько пустых элементов 
 * 'member' с атрибутами 'role' и 'name'. 
 * 
 * Каждое значение атрибута 'name' элемента 'project' — 
 * это непустая последовательность из строчных латинских букв и символа 
 * 'дефис' (он же 'минус').
 * 
 * Значение атрибута 'role' элемента 'member' — это также непустая 
 * последовательность из строчных латинских букв и символа 'дефис' 
 * (он же 'минус').
 * 
 * Значение атрибута 'name' элемента 'member' — это также непустая 
 * последовательность из строчных и заглавных латинских букв и пробелов.
 * Значение этого атрибута не может начинаться или заканчиваться пробелом.
 * Других атрибутов, кроме тех, что описаны выше, у элементов нет.
 * 
 * Необходимо преобразовать этот документ в следующий вид:
 * 1) корневым элементом результата должен быть элемент с именем 'members';
 * 2) элемент 'members' содержит один или несколько элементов 'member' 
 * с единственным атрибутом 'name';
 * 3) каждый элемент 'role' содержит один или несколько пустых элементов 
 * 'role' с атрибутами 'project' и 'name'. 
 * 
 * Для дополнительных разъяснений изучите пример входных и выходных данных. 
 * Учтите, что при сравнении значений атрибутов регистр букв имеет значение.
 * 
 * Входные данные
 * Входные данные состоят из некоторого количества строк, образующих 
 * XML-документ в описанном выше формате. Все элементы 'project' 
 * имеют уникальные значения атрибутов 'name'. Каждый элемент 
 * находится на отдельной строке. Строки с открывающим и закрывающим 
 * тегами элемента 'projects' не содержат начальных пробелов, 
 * в начале строк с тегами элементов 'project' ровно четыре пробела, 
 * в начале строк с тегами элементов 'member' — ровно восемь пробелов. 
 * Строки не содержат концевых пробелов. Атрибуты внутри элементов 
 * разделены единичными пробелами. У любых двух элементов 'member' 
 * внутри одного и того же элемента 'project' различаются 
 * либо значения атрибута 'role', либо значения атрибута 'name', 
 * либо и те, и другие одновременно.
 *
 * Выходные данные
 * Выведите документ в требуемом формате. Строго соблюдайте формат, 
 * показанный в примере выходных данных. Атрибуты элемента 'role' 
 * должны следовать в следующем порядке: сначала 'name', затем 'project'. 
 * Элементы 'member' должны следовать в лексикографическом порядке 
 * значений атрибутов 'name'. В каждом элементе 'member' элементы 
 * 'role' должны следовать в лексикографическом порядке значений 
 * атрибутов 'project', а при равенстве — в лексикографическом порядке 
 * значений атрибутов 'name'.
 * 
 * Все лексикографические сравнения осуществляйте с учетом регистра 
 * символов. Например, строка 'Ba' лексикографически меньше строки 
 * 'aa'.
 * 
 * ========= Пример 1 =========
 * input
 * <projects>
 *     <project name="xml">
 *        <member role="developer" name="Fedya"/>
 *        <member role="manager" name="Ivan"/>
 *        <member role="manager" name="Fedya"/>
 *    </project>
 * </projects>
 * 
 * output
 * <members>
 *   <member name="Fedya">
 *       <role name="developer" project="xml"/>
 *       <role name="manager" project="xml"/>
 *   </member>
 *   <member name="Ivan">
 *      <role name="manager" project="xml"/>
 *   </member>
 * </members>
 * 
 * 
 * ========= Пример 2 =========
 * input
 * <projects>
 *    <project name="xml">
 *        <member role="developer" name="fedya"/>
 *        <member role="manager" name="Ivan"/>
 *    </project>
 *    <project name="rpc">
 *        <member role="developer" name="fedya"/>
 *    </project>
 * </projects>
 *
 * output
 * <members>
 *    <member name="Ivan">
 *        <role name="manager" project="xml"/>
 *    </member>
 *    <member name="fedya">
 *        <role name="developer" project="rpc"/>
 *       <role name="developer" project="xml"/>
 *    </member>
 * </members>
 */

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {	
    public static void main(String[] args) throws TransformerException { 
    	try {
            DocumentBuilder inDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document inDocument = inDocumentBuilder.parse("input.xml"); 
            
            Document outDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element outMembers = outDocument.createElement("members");
            outDocument.appendChild(outMembers);            
           
            Element inRoot = inDocument.getDocumentElement();
            NodeList inProjects = inRoot.getChildNodes(); //projects
            for (int i = 0; i < inProjects.getLength(); i++) {
                org.w3c.dom.Node inProject = inProjects.item(i);
                if (inProject.getNodeType() != Node.TEXT_NODE) {
                    NodeList inMembers = inProject.getChildNodes(); //members
                    for(int j = 0; j < inMembers.getLength(); j++) {
                        org.w3c.dom.Node inMember = inMembers.item(j); 
                        if (inMember.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(inMember.getNodeName() + " " + inMember.getAttributes().getNamedItem("role") + " " + inMember.getAttributes().getNamedItem("name"));                            
                            
                            Element outMember = outDocument.createElement("member");
                            outMembers.appendChild(outMember);                            
                            Attr outMemberName = outDocument.createAttribute("name");
                            outMemberName.setTextContent(inMember.getAttributes().getNamedItem("name").getNodeValue());
                            outMember.setAttributeNode(outMemberName);
                            
                            Element outRole = outDocument.createElement("role");
                            outMember.appendChild(outRole);
                            Attr outRoleName = outDocument.createAttribute("name");
                            outRoleName.setTextContent(inMember.getAttributes().getNamedItem("role").getNodeValue());
                            outRole.setAttributeNode(outRoleName);
                            Attr outProjectName = outDocument.createAttribute("project");
                            outProjectName.setTextContent(inProject.getAttributes().getNamedItem("name").getNodeValue());
                            outRole.setAttributeNode(outProjectName);
                        }
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(outDocument), new StreamResult("output.xml"));
         } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
         } catch (SAXException ex) {
                ex.printStackTrace(System.out);
         } catch (IOException ex) {
                ex.printStackTrace(System.out);
         }
    }
}

