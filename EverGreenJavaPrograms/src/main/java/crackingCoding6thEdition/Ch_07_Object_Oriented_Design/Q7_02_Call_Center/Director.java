package crackingCoding6thEdition.Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

class Director extends Employee {
    public Director(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Director;
    }
}
