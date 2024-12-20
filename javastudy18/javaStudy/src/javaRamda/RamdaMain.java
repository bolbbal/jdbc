package javaRamda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Addable { // 함수형 인터페이스
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
		// 함수형 인터페이스
		// 단 하나의 추상 메서드만 가진 인터페이스
		// 함수형 인터페이스는 람다식과 메서드 참조에 사용할 수 있다.
		// @FunctionalInterface 어노테이션을 사용해 명시적으로 나타낼 수 있다.

		// java.util.function.Predicate<T> : 매개변수 T를 받아서 boolean을 반환하는 함수
		// java.util.function.Function<T, R> : 매개변수 T를 받아서 결과 R을 반환하는 함수

		// 익명클래스
		// 익명(AnonyMous Class)는 이름이 없는 클래스
		// 일회성으로 사용됨
		// 클래스의 선언과 객체 생성을 동시에 하기 때문에 단 한번만 사용할 수 있다.
		// 오직 하나의 객체만을 생성할 수 있는 일회용 클래스

		// 람다식
		// 메서드를 하나의 식으로 표현한 것
		// 람다식은 함수를 간략하면서도 명확하게 표현할 수 있게 해준다
		// 작성방법
		// 메서드의 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 -> 를 추가한다

		//implements
		Addfunc af = new Addfunc();
		int result = af.add(10, 20);
		System.out.println(result);

		//ramda
		Addable add = (a, b) -> a + b; 
		int result1 = add.add(10, 20);
		System.out.println("Max value = " + result1);
		
		//출력할때 람다식
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("BBB");
		list.add("ccc");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		//확장된 for문
		for(String s : list) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		//람다식
		list.forEach(s -> System.out.print(s + " "));
		
		
	}

}
