package JavaAbstract;

class StudentAve extends Student {
	
	@Override
	public void ave() { //구현부{}를 만들어야 한다
		super.ave = super.tot / 3.;
	}
}
public class StudentMain {

	public static void main(String[] args) {
		//추상 클래스
		//미완성 설계도라고 하며, 미완성 메서드를 갖고있는 클래스를 말한다.
		//객체생성(Instance)은 할 수 없다.
		//상속을 통해 추상 메서드를 완성해야 객체 생성이 가능하다.
		//추상 클래스는 추상 메서드를 포함하고 있다는 것을 제외하고는 일반 클래스와 같다.
		//추상 클래스에도 생성자가 있으며, 멤버 변수와 메서드도 가질 수 있다.
		//키워드 : Abstract
		
		//추상 메서드란
		//미완성 메서드. 구현부(몸통{})가 없는 메서드
		//abstract 리턴타입 메서드이름(); - > 선언부만 있고 구현부가 없는 메서드
		//꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우에 사용
		
//		Student stu = new Student(); // 에러
		
		StudentAve sta = new StudentAve();
		sta.id = "2024";
		sta.name = "jsl";
		sta.kor = 100;
		sta.eng = 100;
		sta.mat = 100;
		sta.tot();
		sta.ave();
		
	}

}
