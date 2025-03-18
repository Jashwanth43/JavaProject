package in.ineuron.bean;

public class Car {
	private String regNo;
	private int engineNo;
	private String type;
	private String model;
	private String company;
	private String color;
	private int engineCC;
	private String owner;
	private String fuelType;

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Car(String regNo, int engineNo, String type, String model, String company, String color, int engineCC,
			String owner, String fuelType) {
		this.regNo = regNo;
		this.engineNo = engineNo;
		this.type = type;
		this.model = model;
		this.company = company;
		this.color = color;
		this.engineCC = engineCC;
		this.owner = owner;
		this.fuelType = fuelType;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", engineNo=" + engineNo + ", type=" + type + ", model=" + model + ", company="
				+ company + ", color=" + color + ", engineCC=" + engineCC + ", owner=" + owner + ", fuelType="
				+ fuelType + "]";
	}

}
