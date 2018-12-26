package com.model;

/**
 * @author zulkarnaen
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.DAO.InsertFamily;
import com.DAO.InsertRecord;
import com.datakeluarga.Family;

public class XMLtoDB1 {

	public static void main(String[] args) {

		try {
			// TODO: Data diambil di file local
			File file = new File("D:/DBtoXML.xml");

			// TODO: Membuat document baru
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			System.out.println("----------------------- Unmarshing Starting! ------------------------\n");

			// TODO: print untuk mendapatkan document element (node name nya)
			System.out.println("----------------------> Root element :" + doc.getDocumentElement().getNodeName() + " <----------------------");

			System.out.println("---------------------------------------------------------------------");

			// TODO: membuat nodelist dengan nama record
			NodeList nList = doc.getElementsByTagName("record");

			// TODO: Memanggil family
			Family ambilDataRecord = new Family();
			Family ambilDataFamily = new Family();

			// TODO: membuat pengulangan.
			for (int temp = 0; temp < nList.getLength(); temp++) {

				// TODO: Node nNode adalah item nlist(record) yang berisi temp
				// (perhitungan)
				Node nNode = nList.item(temp);

				// TODO: print current element yaitu nNode.getNodeName adalah record
				System.out.println("\nElement	: " + nNode.getNodeName() + " <---------------------------------------------------");

				// TODO: jika nNode nodetype sama dengan node.element_node
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					// TODO: dapatkan semua element tag untuk isi dari record
					// (isinya dari url)
					String nama = eElement.getElementsByTagName("name").item(0).getTextContent();
					String telp = eElement.getElementsByTagName("phone").item(0).getTextContent();
					String email = eElement.getElementsByTagName("email").item(0).getTextContent();
					String kota = eElement.getElementsByTagName("city").item(0).getTextContent();

					// TODO: ambil data nya untuk simpan di record
					ambilDataRecord.setName(nama);
					ambilDataRecord.setPhone(telp);
					ambilDataRecord.setEmail(email);
					ambilDataRecord.setCity(kota);

					// TODO: print untuk membuktikan
					System.out.println("FName	: " + nama);
					System.out.println("phone	: " + telp);
					System.out.println("email	: " + email);
					System.out.println("city	: " + kota);

					// TODO: insert data record ke InsertRecord.SimpanRecord
					InsertRecord.SimpanRecord(ambilDataRecord);

					// SELESAI RECORD ------------------------------------------------------------------------
					
					// TODO: membuat nodelist dengan nama family
					NodeList nList1 = eElement.getElementsByTagName("family");

					// TODO: membuat pengulangan.
					for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {

						// TODO: Node nNode adalah item nlist1(family) yang berisi temp1 (perhitungan)
						Node nNode1 = nList1.item(temp1);

						// TODO: print current element yaitu nNode.getNodeName adalah record
						System.out.println("\nElement	: " + nNode1.getNodeName() + " <---------------------------------------------------");

						// TODO: jika nNode nodetype sama dengan node.element_node
						if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement1 = (Element) nNode1;

							// TODO: dapatkan semua element tag untuk isi dari family (isinya dari url)
							String anak = eElement1.getElementsByTagName("child").item(0).getTextContent();
							String orangTua = eElement1.getElementsByTagName("parent").item(0).getTextContent();

							// TODO: ambil data nya untuk simpan di Family
							ambilDataFamily.setChild(anak);
							ambilDataFamily.setParent(orangTua);
							ambilDataFamily.setName(nama);

							// TODO: print untuk membuktikan
							System.out.println("Child	: " + anak);
							System.out.println("Parent	: " + orangTua);

							System.out.println("\n---------------------------------------------------------------------");

							// TODO: insert data record ke InsertFamily.SimpanFamily
							InsertFamily.SimpanFamily(ambilDataFamily);
							
							// SELESAI FAMILY ------------------------------------------------------------------------
						}
					}
				}
			}
			// TODO: catch jika terjadi error dan print menggunakan printStackTrace
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------------- Unmarshing Complete! ------------------------\n");
	}

}
