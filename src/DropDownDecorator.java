public class DropDownDecorator implements Form{
    private String Name;
    private String[] Options;
    private Form form;
    private String value;
    public DropDownDecorator(Form form) {
        this.form = form;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setOptions(String[] options) {
        Options = options;
    }
    @Override
    public void GetDataFromUser() {
        form.GetDataFromUser();
        System.out.println("Enter the "+Name);
        for(int i = 0 ; i < Options.length ; i++) {
            System.out.println((i+1) + ". " + Options[i]);
        }
        int choice=InputDataHandle.UserInput(1, Options.length);
        this.value=Options[choice-1];
        System.out.println("You have selected " + Options[choice-1]);
    }
}
