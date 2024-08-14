package javaRamda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Addable { // �Լ��� �������̽�
	int add(int a, int b);
}

class Addfunc implements Addable {
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
}

public class RamdaMain {

	public static void main(String[] args) {
		// �Լ��� �������̽�
		// �� �ϳ��� �߻� �޼��常 ���� �������̽�
		// �Լ��� �������̽��� ���ٽİ� �޼��� ������ ����� �� �ִ�.
		// @FunctionalInterface ������̼��� ����� ���������� ��Ÿ�� �� �ִ�.

		// java.util.function.Predicate<T> : �Ű����� T�� �޾Ƽ� boolean�� ��ȯ�ϴ� �Լ�
		// java.util.function.Function<T, R> : �Ű����� T�� �޾Ƽ� ��� R�� ��ȯ�ϴ� �Լ�

		// �͸�Ŭ����
		// �͸�(AnonyMous Class)�� �̸��� ���� Ŭ����
		// ��ȸ������ ����
		// Ŭ������ ����� ��ü ������ ���ÿ� �ϱ� ������ �� �ѹ��� ����� �� �ִ�.
		// ���� �ϳ��� ��ü���� ������ �� �ִ� ��ȸ�� Ŭ����

		// ���ٽ�
		// �޼��带 �ϳ��� ������ ǥ���� ��
		// ���ٽ��� �Լ��� �����ϸ鼭�� ��Ȯ�ϰ� ǥ���� �� �ְ� ���ش�
		// �ۼ����
		// �޼����� �̸��� ��ȯŸ���� �����ϰ� �Ű����� ����ο� ����{} ���̿� -> �� �߰��Ѵ�

		//implements
		Addfunc af = new Addfunc();
		int result = af.add(10, 20);
		System.out.println(result);

		//ramda
		Addable add = (a, b) -> a + b; 
		int result1 = add.add(10, 20);
		System.out.println("Max value = " + result1);
		
		//����Ҷ� ���ٽ�
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("BBB");
		list.add("ccc");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		//Ȯ��� for��
		for(String s : list) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		//���ٽ�
		list.forEach(s -> System.out.print(s + " "));
		
		
	}

}