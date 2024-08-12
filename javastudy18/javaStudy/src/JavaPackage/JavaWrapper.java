package JavaPackage;

public class JavaWrapper {
	
	public static void main(String[] args) {
		//Wrapper 클래스
		//기본타입 : 	byte	short	int	long	char	float	double	boolean
		//Wrapper : Byte	Short	Int	Long	Char	Float	Double	Boolean
		//이름이 Wrapper라는 클래스는 존재하지 않는다.
		//기본타입의 값을 객체로 변환하고 싶을 때 사용한다.
		
		//기본타입
		Integer i = new Integer(10);
		Character c = new Character('A');
		Double d = new Double(3.14);
		Boolean b = new Boolean(true);
		
		//문자열
		Integer ten = new Integer("10");
		Double dou = new Double("3.14");
		Boolean boo = new Boolean("true");
		
		//Float 객체는 double 타입의 값으로 생성 가능
		Float f = new Float((double)3.14);
		
		//기본타입 값 알아내기
		System.out.println(i.intValue());
		System.out.println(c.charValue());
		System.out.println(d.doubleValue());
		System.out.println(b.booleanValue());
		
		
		//문자열을 기본 데이터 타입으로 변환
		int i2= Integer.parseInt("123"); //문자열을 정수 형태로 변환 ★
		System.out.println(i2); //123
		boolean b2 = Boolean.parseBoolean("true");
		System.out.println(b2); //true
		double d2 = Double.parseDouble("3.14");
		System.out.println(d2); //3.14
		
		//기본타입을 문자열로 변환
		String s1 = Integer.toString(123);
		System.out.println(s1); // "123"
		String s2 = Integer.toHexString(123); //정수 123을 16진수 문자열 7b로 변환
		System.out.println(s2); //
		
		//박싱(Boxing)
		//기본 타입의 값을 Wrapper 객체로 변환
		//언박싱(Unboxing)
		//Wrapper 객체에 들어있는  값을 기본 타입으로 변환
		//자동박싱(Auto Boxing)
		
		Integer te = 10; //자동 박싱
		int n = te; //자동 언박싱
		
	}
	
	
}
