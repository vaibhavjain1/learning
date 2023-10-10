package designPatterns.builder_pattern.productionCodeDesign;

public class User_ProdcutionCode2 {
	
	private static UserBuilder instance;
	public class UserBuilder{
		int id;
		String name;
		
		public UserBuilder setId(int id){
			this.id = id;
			return this;
		}
		
		public UserBuilder setName(String name){
			this.name = name;
			return this;
		}
	}
	
	public static UserBuilder UserBuilderInstance() {
        if(instance==null){
        	synchronized (User_ProdcutionCode2.class) {
				if(instance==null)
					instance = new User_ProdcutionCode2().new UserBuilder();
			}
        }
        return instance;
    }
	
	public static UserBuilder id(int id){
		return UserBuilderInstance().setId(id);
	}
	
	public static UserBuilder name(String name){
		return UserBuilderInstance().setName(name);
	}
	
	public static void main(String[] args) {
		
	}
}
