package iuh.fit.se.taskmanagement;

public class TeamMember implements Observer {
	private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        System.out.println("Thành viên " + name + " nhận thông báo: Trạng thái công việc đã thay đổi thành: " + task.getStatus());
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
