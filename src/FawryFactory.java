
public class FawryFactory implements FawryFactoryInterface {
	public IRole GetRole(int RoleID) {
		switch (RoleID) {
        case 1:
            return new Admin();
        case 2:
            return new User();
        default:
            return null;
    }
	}
}
