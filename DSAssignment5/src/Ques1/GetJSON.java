package Ques1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

/* This is a component class.
 * This class uses JSONParser for parsing data from JSON file.
 * @author Vinod
 */
public class GetJSON {
	
	/* This method returns 
	 * @return
	 * @throws Exception
	 */
	public List<BSTNode> getJSON() throws Exception {
		
		// Reference variables.
		BSTNode treeNode;
		
		// List for storing dictionary entries as node.
		List<BSTNode> BSTList = new ArrayList<BSTNode>(); 
		
		try {
			// Parsing Data.json
			Object obj = new JSONParser().parse(new FileReader("D:\\Development\\Metacube Assignments\\"
					+ "DS-Assignment-5\\src\\Data.json"));
			JSONObject jo = (JSONObject) obj;
			
			// Fetching dictionary elements.
			JSONArray jArray = (JSONArray) jo.get("dictionary");
			
			// Iterating JSON objects.
			Iterator<Map.Entry> iter;
			Iterator iter2 = jArray.iterator();
			
			// Iterating through each JSON object or key-value pairs and adding it to BST.
			while(iter2.hasNext()) {
				iter = ((Map)iter2.next()).entrySet().iterator();
				while(iter.hasNext()) {
					Map.Entry pair = iter.next();	
					treeNode = new BSTNode();
					treeNode.key = Integer.parseInt((String)pair.getKey());
					treeNode.value = (String) pair.getValue();
					BSTList.add(treeNode);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return BSTList;
	}
}
