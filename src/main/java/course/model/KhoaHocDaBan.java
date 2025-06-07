package course.model;

public class KhoaHocDaBan {
	private String name;
	private int[] data;

	public KhoaHocDaBan(String name, int[] data) {
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}
}
