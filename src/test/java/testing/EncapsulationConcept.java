package testing;

public class EncapsulationConcept {

	private String name;
	private int bankBalance;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	
	public static void main(String[] args) {
		EncapsulationConcept en = new EncapsulationConcept();
		
		en.setName("Mohan");
		System.out.println(en.getName());
		
		en.setBankBalance(999999999);
		System.out.println(en.getBankBalance());
		
	}
	
}
