import java.util.Scanner;

public class TextFieldDecorator implements Form {
    private Form form;
    private Integer valueInt=null;
    private String valueString=null;
    private Double valueDouble=null;
    private Boolean valueBoolean=null;
    private String Name ;
    public TextFieldDecorator(Form form) {
        this.form = form;
    }
    @Override
    public void GetDataFromUser() {
        form.GetDataFromUser();
        System.out.println("Enter the "+Name);
        Scanner scanner = new Scanner(System.in);
        if(valueInt!=null) {
            valueInt = scanner.nextInt();
        }
        else if(valueString!=null) {
            valueString = scanner.nextLine();
        }
        else if(valueBoolean!=null) {
            valueBoolean = scanner.nextBoolean();
        }
        else if(valueDouble!=null) {
            valueDouble = scanner.nextDouble();
        }
    }
    public void setName(String name) {
        Name = name;
    }
    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
    }
    public void setValueString(String valueString) {
        this.valueString = valueString;
    }
    public void setValueDouble(Double valueDouble) {
        this.valueDouble = valueDouble;
    }
    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }
    public String getName() {
        return Name;
    }
    public Integer getValueInt() {
        return valueInt;
    }
    public String getValueString() {
        return valueString;
    }
    public Double getValueDouble() {
        return valueDouble;
    }
    public Boolean getValueBoolean() {
        return valueBoolean;
    }

}
