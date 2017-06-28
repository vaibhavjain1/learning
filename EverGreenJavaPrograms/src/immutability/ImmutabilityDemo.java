package immutability;

import java.util.ArrayList;
import java.util.Collections;

/*
1.	Declare class as final so that no class will be able to override.
2.	make all members private and final, set them explicitly, in a static block, or in the constructor
3.	No Methods that modify state
4.	Use defensive copying for mutable members
5. 	Use deep copy for collections so that internal Integer won't be changed
*/

import java.util.Date;
import java.util.List;

final class Immutable{
	final private int localVar;
	final private Date dateVar;
	final private List<Integer> listVar;
	
	Immutable(int localVar, Date dateVar, List<Integer> listVar){
		this.localVar = localVar;
		this.dateVar = (Date) dateVar.clone();
		// For collections we need to provide deep copy for all the Integers
		this.listVar = new ArrayList<>();
		for (Integer Integer : listVar) {
			listVar.add(deepCopyListIntegers(Integer));
		}
	}
	private Integer deepCopyListIntegers(Integer Integer) {
		return new Integer(Integer.intValue());
	}
	
	public int getLocalVar(){
		return this.localVar;
	}
	public Date getDateVar(){
		// Instead of cloning we can return new Integer
		return new Date(this.dateVar.getTime());
	}
	public List<Integer> getListVar(){
		return Collections.unmodifiableList(this.listVar);
	}
}

public class ImmutabilityDemo {
	public static void main(String[] args) {
		
	}
}
