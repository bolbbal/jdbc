package JavaCollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		//HashMap<K, V>
		//Ű�� ���� ������ ������ ��Ҹ� �ٷ�� �÷���
		//�ε����� �̿��Ͽ� ��ҿ� ������ �� ����, ���� �˻��ϱ� ���ؼ��� �ݵ�� Ű�� ����ؾ��Ѵ�.
		//��� ���� : put(), ��� �˻� : get()
		
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("ã�� ���� �ܾ� �Է� : ");
			String eng = sc.next();
			if(eng.equals("quit")) {
				//���1
				Set<String> keySet = dic.keySet(); //key�� ������
				for(String key : keySet) {
					System.out.println(key + " : " + dic.get(key));
				}
				
				//���2
				Collection<String> values = dic.values(); //value�� ������
				System.out.println(values);
				
				//���3
				dic.forEach((key,value) -> { // -> ���ٽ�
					System.out.println(key + " : " + value);
				});
				
				System.out.println("����!");
				break;
			}
			
			String kor = dic.get(eng); //eng key�� ȣ���ϸ� value���� ������ �ش�.
			if(kor == null) {
				System.out.println(eng + "�� ���� �ܾ�");
			} else {
				System.out.println(kor);
			}
		}

	}

}
