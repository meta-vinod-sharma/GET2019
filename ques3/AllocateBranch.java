package ques3;

import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class AllocateBranch {
	CounsellingProcess Obj1 = new CounsellingProcess();
	StudentPreference Obj2 = new StudentPreference();
	static Queue<String> allocatedBranch = new LinkedList<>();
	static Queue<String> studentName = new LinkedList<>();

	public void studentAllocation() throws BiffException, IOException {
		Obj1.readExcelOfPgm();
		Obj2.readExcel();
		int flag = 0;
		System.out.println(Obj2.student.size());
		for (int i = 0; i < Obj2.student.size(); i++) {
			ArrayList<String> perticulatStudentBranch = new ArrayList<String>();
			perticulatStudentBranch = Obj2.student.get(i).preference;
			for (int j = 0; j < perticulatStudentBranch.size(); j++) {
				String studentBranch = perticulatStudentBranch.get(j);
				for (int k = 0; k < Obj1.program.size(); k++) {
					if (studentBranch.equals(Obj1.program.get(k).branchName)) {
						if (Obj1.program.get(k).capacity != 0) {
							allocatedBranch.add(studentBranch);
							studentName.add(Obj2.student.get(i).studentName);
							Obj1.program.get(k).capacity = Obj1.program.get(k).capacity - 1;
							flag = 1;
							break;
						} else {
							flag = -1;
							break;
						}
					}
				}
				if (flag == 1) {
					break;
				}
			}
		}
		System.out.println(studentName);
		System.out.println(allocatedBranch);
	}

	public void writeFile() {
		int index = 0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/P/AllocateStudent.xls"));
			WritableSheet workbookSheet = workbook.createSheet("sheet1", 0);
			int index1;
			index = studentName.size();
			for (index1 = 0; index1 < index; index1++) {
				//System.out.println(studentName.size());
				String name = studentName.remove();
				Label nameLabel = new Label(0, index1, name);
				workbookSheet.addCell(nameLabel);

				String program = allocatedBranch.remove();
				Label programLabel = new Label(1, index1, program);
				workbookSheet.addCell(programLabel);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws BiffException, IOException {
		AllocateBranch obj = new AllocateBranch();
		
		obj.studentAllocation();
		obj.writeFile();
	}
}
