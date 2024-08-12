package javaObject;

public class Java04_class {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[4];
		
		Employee emp1 = new Employee("E001", "±èÅÂÇü", "01", "20", "31", "C", "20200525");
		Employee emp2 = new Employee("E002", "¹ÚÁö¹Î", "02", "30", "32", "A", "20200525");
		Employee emp3 = new Employee("E003", "Á¤È£¼®", "03", "40", "32", "D", "20200525");
		Employee emp4 = new Employee("E004", "¹ÎÀ±±â", "04", "50", "40", "B", "20200525");
	
		empArray[0] = emp1;
		empArray[1] = emp2;
		empArray[2] = emp3;
		empArray[3] = emp4;
		
//		emp1.title();
//		emp1.getList();
//		emp2.getList();
//		emp3.getList();
//		emp4.getList();
		
//		for (int i = 0; i < empArray.length; i++) {
//			empArray[i].getList();
//		}
		
		EmployeeDao dao = new EmployeeDao();
		
		dao.title();
		dao.getList(empArray);
	}

}
