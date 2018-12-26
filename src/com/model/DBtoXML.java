package com.model;

/**
 * @author zulkarnaen
 */

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.DAO.SelectData;
import com.datakeluarga.Family;

public class DBtoXML {

	public static void main(String[] args) {
		// TODO:
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		System.out.println("------------------------- Marshing Starting! ------------------------\n");
		try {
			// TODO: Membuat Document baru
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// TODO: Menambah Element ke Document (bernama records)
			Element rootElement = doc.createElement("records");

			// TODO: Menambah root element
			doc.appendChild(rootElement);

			// TODO: Menambah elemt child pertama ke root element
			List<Family> ambilDataFamily = SelectData.ambilData();
			for (Family bacaFamily : ambilDataFamily) {

				// TODO: untuk print record dan family
				// System.out.println(baca.getName());
				// System.out.println(baca.getPhone());
				// System.out.println(baca.getEmail());
				// System.out.println(baca.getCity());
				// System.out.println(baca.getChild());
				// System.out.println(baca.getParent());

				// TODO: Menambahkan ke document (nama, phone, email, city, child, parent)
				rootElement.appendChild(getPribadi(doc, bacaFamily.getName(), bacaFamily.getPhone(), bacaFamily.getEmail(),
						bacaFamily.getCity(), bacaFamily.getChild(), bacaFamily.getParent()));
			}

			// TODO: pengeluaran output ke console
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// TODO: Berikan xml value untuk outputnya
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			DOMSource source = new DOMSource(doc);

			// TODO: Tulis di console dan simpan ke file (di D:/DBtoXML.xml)
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("D:/DBtoXML.xml"));

			// TODO: Tulis data
			transformer.transform(source, console);
			transformer.transform(source, file);
			System.out.println("\n------------------------- Marshing Complete ------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//-------------------------------------------------- FUNGSI RECORD --------------------------------------------------------------------------------
	/**
	 * @author zulkarnaen
	 */
	// TODO: Membuat Fungsi untuk membuat record pada records
	private static Node getPribadi(Document doc, String name, String phone, String email, String city, String child,
			String parent) {
		Element record = doc.createElement("record");
		record.appendChild(getPribadiElements(doc, record, "name", name));
		record.appendChild(getPribadiElements(doc, record, "phone", phone));
		record.appendChild(getPribadiElements(doc, record, "email", email));
		record.appendChild(getPribadiElements(doc, record, "city", city));
		record.appendChild(getFamily(doc, child, parent));

		return record;
	}

	// TODO: utiliti untuk memmbuat node text
	private static Node getPribadiElements(Document doc, Element element, String data, String value) {
		Element node = doc.createElement(data);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

//-------------------------------------------------- FUNGSI FAMILY --------------------------------------------------------------------------------
	/**
	 * @author zulkarnaen
	 */
	// TODO: Membuat Fungsi untuk membuat family didalam record
	private static Node getFamily(Document doc1, String child, String parent) {
		Element family = doc1.createElement("family");

		family.appendChild(getKeluargaElements(doc1, family, "child", child));
		family.appendChild(getKeluargaElements(doc1, family, "parent", parent));

		return family;

	}

	// TODO: utiliti untuk memmbuat node text
	private static Node getKeluargaElements(Document doc1, Element element, String data, String value) {
		Element node = doc1.createElement(data);
		node.appendChild(doc1.createTextNode(value));
		return node;
	}

}
