package JavaPackage;

public class JavaString {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		String s3 = new String("ABC");
		String s4 = new String("ABC");
		System.out.println(s1 == s2); //������ ����
		System.out.println(s3 == s4); //������ �ٸ���
		System.out.println(s1.equals("ABC")); //���ڿ� �� => true ��ȯ ��
		System.out.println(s1.concat("java")); //s1 ���ڿ��� java ���ڸ� ���ٿ���
		int result = s1.compareTo(s2); //���ڿ��� ������ 0 ����, �ٸ��� -1 ����
		System.out.println(result);
		String a = "       abcd      ";
		String b = "       a b c d";
		System.out.println(a);
		System.out.println(a.trim()); // �� ���� ��� ���� ���� ��
		System.out.println(b.trim());
		
		String c = "class";
		System.out.println(c.charAt(2)); //��
		//�� c�� ����� ���� �� s ���ڰ� ��� �ִ��� ����Ͻÿ�
		int count = 0;
		for(int i = 0; i < c.length(); i++) {
			if(c.charAt(i) == 's') {
				count++;
			}
		}
		System.out.println(count);
		
		String java = "java is very good";
		String cshap = "c#, c++";
		String re = java.replace("java", "phython");
		System.out.println(re);
		
		String array[] = cshap.split(","); //��ȣ�� �߽����� ���ڿ� �и� ��
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println(java.substring(0,4)); //java �迭�� 0��° ���ں��� 4��° ������ �ձ��� ��¡� 
		System.out.println(java.substring(5)); //5�� ���ں��� ������
		String idCheck = "123456-1234567";
		char id = idCheck.charAt(7);
		if(id == '1') {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
		
		String ext = "my.jpg";
		String[] picArr = ext.split("\\.");
		if(picArr[1].equalsIgnoreCase("jpg")) { //��,�ҹ��� ����
			System.out.println("�׸����� �Դϴ�.");
		} else {
			System.out.println("�׸����ϸ� ���ε� �����մϴ�.");
		}
		
		String subject = "Java programming";
		System.out.println(subject.indexOf("programming")); //�Ű������� �־��� ���ڿ��� ���۵Ǵ� �ε��� ��ȣ�� ����, �־��� ���ڿ��� ���ԵǾ����� ������ -1 ����
		if(subject.indexOf("programming") != -1) {
			System.out.println("���ڿ��� �־��");
		} else {
			System.out.println("ã�� ���ڿ��� �����");
		}
		
		System.out.println(subject.toLowerCase()); //�ҹ��ڷ� ����
		System.out.println(subject.toUpperCase()); //�빮�ڷ� ����
		
		String str1 = "java";
		String str2 = "JAVA";
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("���ƿ�");
		}
	}

}
