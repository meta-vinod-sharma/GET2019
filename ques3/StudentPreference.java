package ques3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StudentPreference {
	@SuppressWarnings("rawtypes")
	Map<String, ArrayList> map = new HashMap<String, ArrayList>();
	ArrayList<Student> student = new ArrayList<Student>();

	@SuppressWarnings("unchecked")
	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:\\MyWorkspace\\Students.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		String name = null;
		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");
		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		for (int row = 0; row < totalNoOfRows; row++) {
			name = sh.getCell(0, row).getContents().toString();
			ArrayList<String> branch = new ArrayList<String>();
			for (int col = 1; col < totalNoOfCols; col++) {
				branch.add(sh.getCell(col, row).getContents().toString());
			}
			map.put(name, branch);
			System.out.println();
		}
		for (@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
			String key = (String) entry.getKey();
			ArrayList<String> values = new ArrayList<String>();
			values = (ArrayList<String>) entry.getValue();
			System.out.println("Key = " + key);
			System.out.println("Values = " + values);
			student.add(this.addStudent(key, values));
		}
		System.out.println(student);
	}
	private Student addStudent(String key, ArrayList<String> values) {
		return new Student(key, values);
	}
}
