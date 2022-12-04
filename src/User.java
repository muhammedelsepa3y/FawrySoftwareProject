import java.util.List;
import java.util.Scanner;
public class User extends IRole implements UserServices{

	@Override
	public String GetRoleName() {
		return "User";
	}
	@Override
	public void start(boolean isAdmin) {
		super.start(isAdmin);
		while(true){
			System.out.println("\nWelcome "+Authentication.CurrentUser.getUsername());
			System.out.println("1. Pay Bill");
			System.out.println("2. Search Service");
			System.out.println("3. Wallet Recharge");
			System.out.println("4. Print Discounts");
			System.out.println("5. Refund Service");
			System.out.println("6. Get Wallet Balance");
			System.out.println("7. Check Refund Status");
			System.out.println("8. Logout");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			while (choice < 1 || choice > 8) {
				System.out.println("Invalid choice");
				System.out.println("Please enter your choice:");
				choice = scanner.nextInt();
			}
			switch (choice) {
				case 1:
					this.payBill();
					break;
				case 2:
					this.searchService();
					break;
				case 3:
					this.walletRecharge();
					break;
				case 4:
					this.PrintDiscounts();
					break;
				case 5:
					this.refundService();
					break;
				case 6:
					this.getWalletBalanced();
					break;
				case 7:
					this.checkMyRefundsRequests();
					break;
				case 8:
					Authentication.Logout();
					return;
			}
		}
	}
	@Override
	public void payBill() {
		Authentication.CurrentUser.addTransaction(new TransactionModel("Recharge Mobile",1000,"01000000000",Authentication.CurrentUser));

	}
	@Override
	public void searchService() {

	}
	@Override
	public void walletRecharge() {
		System.out.println("Enter the amount:");
		Scanner scanner = new Scanner(System.in);
		int amount = scanner.nextInt();

	}
	@Override
	public void PrintDiscounts() {

	}
	public TransactionModel GetTransactionById(int id){
		for(TransactionModel i :Authentication.CurrentUser.getTransaction()){
			if(i.getId() == id){
				return i;
			}
		}

		return null;
	}
	@Override
	public void refundService() {
		boolean flag = false;
		for (TransactionModel i : Authentication.CurrentUser.getTransaction()) {
			flag = true;
			System.out.println("Transaction Id: " + i.getId());
			System.out.println(i.getServiceName());
			System.out.println(i.getAmount());
			System.out.println(i.getDate());
			System.out.println("-----------------------");
		}

	}
	@Override
	public void getWalletBalanced() {

	}
	@Override
	public void checkMyRefundsRequests() {


	}
}