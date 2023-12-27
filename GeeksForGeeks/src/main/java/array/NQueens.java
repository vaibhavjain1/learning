package array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NQueens {

	Map<Integer,Integer> queenMap= new LinkedHashMap<>();

	public boolean checkConflictingQueen(int row, int col) {
		Set<Map.Entry<Integer, Integer>> entryset = queenMap.entrySet();
		for (Entry<Integer, Integer> entry : entryset) {
			// Check for the row
			if(entry.getKey()==row)
				return false;
			
			// Check for the diagonal downwards
			for (int i = entry.getKey(), j=entry.getValue(); i < 9; i++, j++) {
				if(i==row && j == col)
					return false;
			}
			
			// Check for the diagonal upwards
			for (int i = entry.getKey(), j=entry.getValue(); i >=0; i--, j++) {
				if(i==row && j == col)
					return false;
			}
		}
		return true;
	}
	
	public boolean checkQueen(int queenCol) {
		// If all queens sorted out return
		if (queenCol == 9)
			return true;

		for (int i = 0; i < 9; i++) {
			if (checkConflictingQueen(i, queenCol)) {
				queenMap.put(i, queenCol);
				if(!checkQueen(queenCol+1)) {
					queenMap.remove(i, queenCol);
				} else {
					break;
				}
			}
			// If no place found backtrack
			if(i==8)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueens obj = new NQueens();
		obj.checkQueen(0);
		System.out.println(obj.queenMap);
	}
}
