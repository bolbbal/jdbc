package bank;

public class BankEx {

	public static void main(String[] args) {
//		
//		BankVo vo = new BankVo();
//		vo.ano = "111";
//		vo.owner = "park";
//		vo.balance = 100000;
//		System.out.println(vo.ano + " " + vo.owner + " " + vo.balance); 
//		
//		BankVo vo1 = new BankVo("222", "jang", 50000);
//		System.out.println(vo1.ano + " " + vo1.owner + " " + vo1.balance);
		
		BankVo vo1 = new BankVo();
		vo1.setAno("111");
		vo1.setOwner("park");
		vo1.setBalance(100000);
		
		BankVo vo2 = new BankVo();
		vo2.setAno("222");
		vo2.setOwner("jang");
		vo2.setBalance(50000);
		
		System.out.println(vo1.getAno() + " " + vo1.getOwner() + " " + vo1.getBalance());
		System.out.println(vo2.getAno() + " " + vo2.getOwner() + " " + vo2.getBalance());
	}

}
