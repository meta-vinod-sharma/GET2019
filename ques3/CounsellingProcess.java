package ques3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CounsellingProcess {
	@SuppressWarnings("rawtypes")
	Map<String, Integer> map = new HashMap<String, Integer>();
	ArrayList<Program> program = new ArrayList<Program>();

	public void readExcelOfPgm() throws BiffException, IOException {
		String FilePath = "C:\\MyWorkspace\\Programs.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		String name = null;
		int capacity = 0;
		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 0; row < totalNoOfRows; row++) {

			name = sh.getCell(0, row).getContents().toString();
			for (int col = 1; col < totalNoOfCols; col++) {
				capacity = Integer.parseInt(sh.getCell(1, row).getContents());
			}
			map.put(name, capacity);
			System.out.println();
		}
		for (Map.Entry entry : map.entrySet()) {
			String key = (String) entry.getKey();
			int values = (int) entry.getValue();
			System.out.println("Key = " + key);
			System.out.println("Values = " + values + "n");
			program.add(this.addPrograms(key, values));
		}

		System.out.println(program);
	}

	private Program addPrograms(String key, int values) {
		return new Program(key, values);
	}

	public static void main(String args[]) throws BiffException, IOException {
		CounsellingProcess DT = new CounsellingProcess();
		DT.readExcelOfPgm();
	}

}
