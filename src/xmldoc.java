//Второй тест (пример 2 в описании задания ниже) данное решение не проходит.

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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Main {
	private static Document stringToDocument(String xml) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private static String toStringFormat(int indent, Document document) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.evaluate("//text()[normalize-space()='']", document,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node node = nodeList.item(i);
                node.getParentNode().removeChild(node);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, SAXException, IOException { 
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
		String xmlString = new String(toStringFormat(4, outDocument));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(stringToDocument(xmlString)), new StreamResult("output.xml"));
    }
}

