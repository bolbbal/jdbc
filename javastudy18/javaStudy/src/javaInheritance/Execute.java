package javaInheritance;

import java.util.Scanner;

public class Execute {

	public static void main(String[] args) {
		Jsl18[] stuArray = new Jsl18[3];
		Jsl18 j181 = new Jsl18();
		Jsl18 j182 = new Jsl18();
		Jsl18 j183 = new Jsl18();
		
		j181.setName("홍길동");
		j181.setAge(500);
		j181.setHeight(178);
		j181.setWeight(97.6);
		j181.setGrade(4);
		j181.setMajor("마술학과");
		stuArray[0] = j181;
		
		j182.setName("최길동");
		j182.setAge(500);
		j182.setHeight(178);
		j182.setWeight(97.6);
		j182.setGrade(4);
		j182.setMajor("마술학과");
		stuArray[1] = j182;
		
		j183.setName("김길동");
		j183.setAge(500);
		j183.setHeight(178);
		j183.setWeight(97.6);
		j183.setGrade(4);
		j183.setMajor("마술학과");
		stuArray[2] = j183;
		
		for(int i = 0; i < stuArray.length; i++) {
			System.out.println(stuArray[i].information());
		}
		
		Employee[] empArray = new Employee[3];
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true) {
			System.out.print("name = ");
			String name = sc.next();
			System.out.print("age = ");
			int age = sc.nextInt();
			System.out.print("height = ");
			double height = sc.nextDouble();
			System.out.print("weight = ");
			double weight = sc.nextDouble();
			System.out.print("salary = ");
			int salaly = sc.nextInt();
			System.out.print("dept = ");
			String dept = sc.next();
			
			
			
			Employee emp1 = new Employee();
			emp1.setName(name);
			emp1.setAge(age);
			emp1.setHeight(height);
			emp1.setSalaly(salaly);
			emp1.setDept(dept);
			empArray[count] = emp1;
			
			count++;
			
			System.out.print("Continue[y/n] : ");
			char choice = sc.next().charAt(0);
			if(choice == 'y' || choice == 'Y') {
				continue;
			} else if(choice == 'n' || choice == 'N') {
				System.out.println("Project end");
				break;
			}
		}
		System.out.println(count + "명 입력");
		for(int i = 0; i < empArray.length; i++) {
			if(empArray[i] != null) {
				System.out.println(empArray[i].information());
			}
		}
	}

}
