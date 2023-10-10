package overriding;

class Question12Base{
	int value = 0;
        Question12Base(){
        	addValue();
        }
        void addValue(){
        	value += 10;
        }
        int getValue(){
        	return value;
        }
}
class Question12Derived extends Question12Base{
	Question12Derived(){
		addValue();
	}
	void addValue(){
		value +=  20;
	}
}
public class Question12{
	public static void main(String[] args){
		Question12Base b = new Question12Derived();
		
		System.out.println(b.getValue());
	}
}