package crackingCoding6thEdition.Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

public class GroupChat extends Conversation {
	public void removeParticipant(User user) {
		participants.remove(user);
	}
	
	public void addParticipant(User user) {
		participants.add(user);
	}
}
