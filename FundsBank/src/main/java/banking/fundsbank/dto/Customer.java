package banking.fundsbank.dto;

//create table customer(acc_num int NOT NULL PRIMARY KEY, first_name varchar(50) NOT NULL, last_name varchar(50), Age int, mobile_num decimal, account_type varchar(50), address varchar(100));
public class Customer {
	private long accNo;
	private String firstName;
	private String lastName;
	private int age;
	private long mobileNumber;
	private String accountType;
	private String address;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long accNo, String firstName, String lastName,int age, long mobileNumber, String accountType,
			String address) {
		super();
		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.accountType = accountType;
		this.address = address;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", mobileNumber=" + mobileNumber + ", accountType=" + accountType + ", address=" + address + "]";
	}

	

}
