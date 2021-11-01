package springII_Ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class User {
	@Autowired
	@Qualifier("adidosShoes")
	Shoes shoes;
	
//	public Shoes getShoes(){
//		return shoes;
//	}
//	
//	public void setShoes(Shoes shoes){
//		this.shoes = shoes;
//	}
	
	public String getShoesBrand(){
		return "선택한 신발 : "+shoes.getBrand();
	}
	
}
