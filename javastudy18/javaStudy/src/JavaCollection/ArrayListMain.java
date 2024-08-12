package JavaCollection;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		//�÷��� ������ ��ũ�ڡ�
		//�ټ��� ��ü�� �ٷ�� ���� ǥ��ȭ�� ���α׷��� ���
		//��ü���� ����Ҵ� �ڵ� ������ �ȴ�
		//����, ������ ���� ����� ��ġ�� �ڵ� ó���ȴ�
		//����ũ���� �迭�� �ٷ�� ������� �ؼ��ߴ�.
		//�پ��� ��ü���� ����, ����, �˻� ���� �۾��� ���� ó���� �� �ִ�.
		
		//�������̽� ����
		//List�� Set�� �θ� �������̽��� Collection �̴�.
		
		//List : ������ �ִ� �������� ����, �������� �ߺ��� ��� ��)����� ���
			//���� Ŭ���� : ArrayList, LinkdList, Stack, Vector
		//Set : ������ �������� �ʴ� �������� ����, �������� �ߺ� ���x
			//��)���� ������ ����, �Ҽ��� ����
			//���� Ŭ���� : HashSet, TreeSet
		//Map : Ű(key)�� ��(Value)�� ������ �̷���� ������ ����
			//������ �������� �ʰ�, Ű�� �ߺ��� ������� �ʰ�, ���� �ߺ��� ����Ѵ�
			//��)�����ȣ, ������ȣ(��ȭ��ȣ)
			//���� Ŭ���� : HashMap, TreeMap, HashTable, Properties
			
		//�÷����� ���׸� ������� �����Ѵ�
		//�÷����� ��Ҵ� ��ü�� �����ϴ�. �⺻ Ÿ���� ��� �Ұ� => Wrapper Ŭ���� ��ȯ(AutoBoxing)
		
		//���׸�(Generices)�̶�
		//��� ������ ������ Ÿ���� �ٷ� �� �ֵ��� �Ϲ�ȭ�� Ÿ�� �Ű� ������ Ŭ������ �޼��带 �ۼ��ϴ� ���
		//Ÿ�� �Ű� ���� : ArrayList<Point>. ArrayList<Student>, ArrayList<People>
		
		//StudentVo ��ü�� �����ϱ� ���� �����迭
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		//ArrayList�� ���� ��ü ����
		StudentVo svo = new StudentVo();
		svo.id = "1";
		svo.name = "ȫ�浿";
		svo.age = "500";
		//������ ��ü�� �����迭�� ���� => add()
		list.add(svo);
		
		StudentVo svo1 = new StudentVo();
		svo1.id = "2";
		svo1.name = "�ڱ浿";
		svo1.age = "200";
		list.add(svo1);
		
		list.remove(0);
		//���
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).id + "\t");
			System.out.println(list.get(i).name + "\t");
			System.out.println(list.get(i).age + "\t");
			System.out.println();
		}
		
		//���� for
		for (StudentVo vo : list) {
			System.out.println(vo.id + "\t");
			System.out.println(vo.name + "\t");
			System.out.println(vo.age + "\t");
		}
		

	}

}
