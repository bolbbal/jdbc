package JavaRegex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {

	public static void main(String[] args) {
		// ���Խ�
		// �ؽ�Ʈ �̿� �� ������ �߿��� ���ϴ� ����(����)�� ��ġ�ϴ� ���ڿ��� ã�Ƴ��� ���� ����ϴ� ��
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.print("��ȭ��ȣ �Է� >> ");
			String tel = sc.next();
			Pattern p = Pattern.compile("\\d{3}-?\\d{4}-?\\d{4}");
			Matcher matcher = p.matcher(tel);
			if(!matcher.find()) {
				System.out.println("��ȭ��ȣ�� �ٽ� �Է����ּ���.");
			} else {
				System.out.println("���Ͽ� �¾ƿ�!");
				check = false;
			}
		} while(check);
		
		
	}

}
