
public class User extends IRole {
	public String GetRoleName() {
		return "User";
	}

	public void start(boolean isAdmin) {
		super.start(isAdmin);
	}
	
}
