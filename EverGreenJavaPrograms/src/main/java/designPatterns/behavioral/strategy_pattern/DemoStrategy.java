package designPatterns.behavioral.strategy_pattern;

/*
 * Definition: Strategy Pattern defines a family of Algorithm, encapsulates each one and
 * make them interchangeable. It enables an algorithm behavior to be selected at runtime
 */

/*
 * Example: 
 * �	java.util.Comparator#compare(), executed by among others Collections#sort().
 * �	javax.servlet.http.HttpServlet, the service() and all doXXX() methods take
 *      HttpServletRequest and HttpServletResponse and the implementor has to process
 *      them (and not to get hold of them as instance variables!).
 */
public class DemoStrategy {
	public static void main(String[] args) {
		// User can dynamically set the class and behavior using getter and setter for Robot
		RobotClass genericRobotObj = new RobotClass("Defensive Robot");
		genericRobotObj.setBehaviourInterfaceObj(new DefensiveBehaviour());
		System.out.println(genericRobotObj.getRobotType());
		System.out.println(genericRobotObj.moveCommand());
	}
}
