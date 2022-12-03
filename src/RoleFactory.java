public class RoleFactory implements IRoleFactory
{
    @Override
    public IRole GetRole(int RoleID) {
        // Factory Pattern
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
