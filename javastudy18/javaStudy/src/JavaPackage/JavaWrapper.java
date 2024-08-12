package JavaPackage;

public class JavaWrapper {
	
	public static void main(String[] args) {
		//Wrapper Ŭ����
		//�⺻Ÿ�� : 	byte	short	int	long	char	float	double	boolean
		//Wrapper : Byte	Short	Int	Long	Char	Float	Double	Boolean
		//�̸��� Wrapper��� Ŭ������ �������� �ʴ´�.
		//�⺻Ÿ���� ���� ��ü�� ��ȯ�ϰ� ���� �� ����Ѵ�.
		
		//�⺻Ÿ��
		Integer i = new Integer(10);
		Character c = new Character('A');
		Double d = new Double(3.14);
		Boolean b = new Boolean(true);
		
		//���ڿ�
		Integer ten = new Integer("10");
		Double dou = new Double("3.14");
		Boolean boo = new Boolean("true");
		
		//Float ��ü�� double Ÿ���� ������ ���� ����
		Float f = new Float((double)3.14);
		
		//�⺻Ÿ�� �� �˾Ƴ���
		System.out.println(i.intValue());
		System.out.println(c.charValue());
		System.out.println(d.doubleValue());
		System.out.println(b.booleanValue());
		
		
		//���ڿ��� �⺻ ������ Ÿ������ ��ȯ
		int i2= Integer.parseInt("123"); //���ڿ��� ���� ���·� ��ȯ ��
		System.out.println(i2); //123
		boolean b2 = Boolean.parseBoolean("true");
		System.out.println(b2); //true
		double d2 = Double.parseDouble("3.14");
		System.out.println(d2); //3.14
		
		//�⺻Ÿ���� ���ڿ��� ��ȯ
		String s1 = Integer.toString(123);
		System.out.println(s1); // "123"
		String s2 = Integer.toHexString(123); //���� 123�� 16���� ���ڿ� 7b�� ��ȯ
		System.out.println(s2); //
		
		//�ڽ�(Boxing)
		//�⺻ Ÿ���� ���� Wrapper ��ü�� ��ȯ
		//��ڽ�(Unboxing)
		//Wrapper ��ü�� ����ִ�  ���� �⺻ Ÿ������ ��ȯ
		//�ڵ��ڽ�(Auto Boxing)
		
		Integer te = 10; //�ڵ� �ڽ�
		int n = te; //�ڵ� ��ڽ�
		
	}
	
	
}
