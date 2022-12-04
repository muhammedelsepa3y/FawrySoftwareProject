
public class User extends IRole implements UserServices{
	public String GetRoleName() {
		return "User";
	}

	public void start(boolean isAdmin) {
		super.start(isAdmin);
	}

	@Override
	public void searchService() {

	}

	@Override
	public void walletRecharge() {

	}

	@Override
	public void PrintDiscounts() {

	}

	@Override
	public void refundService() {

	}

	@Override
	public void checkMyRefundsRequests() {

	}

	@Override
	public void payBill() {

	}

	@Override
	public void getWalletBalanced() {

	}
}
