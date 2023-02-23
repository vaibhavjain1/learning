package creational.builder_pattern;

class Student {
	int rollno;
	String name;
	
	public Student setRollNo(int roll) {
		this.rollno = roll;
		return this;
	}
	
	public Student setName(String name) {
		this.name = name;
		return this;
	}
	
	public Student build() {
		validate(this);
		return this;
	}
	
	public void validate(Student student) {
		// do some basic validation and throw exception in case of failure.
	}
}

public class Main_Builder {
	public static void main(String[] args) {
		Student stud = new Student().setRollNo(10).setName("test").build();
		System.out.println(stud.rollno);
		System.out.println(stud.name);
	}

}
