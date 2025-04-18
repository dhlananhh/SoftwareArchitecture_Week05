package iuh.fit.se.taskmanagement;

public class TaskManagementDemo {

	public static void main(String[] args) {
		// Tạo một công việc
        Task task = new Task("To Do");

        // Tạo các thành viên trong nhóm (Observers)
        TeamMember member1 = new TeamMember("Alice");
        TeamMember member2 = new TeamMember("Bob");
        TeamMember member3 = new TeamMember("Charlie");

        // Đăng ký các thành viên để theo dõi công việc
        task.attach(member1);
        task.attach(member2);

        // Thay đổi trạng thái công việc
        System.out.println("--- Thay đổi trạng thái công việc lần 1 ---");
        task.setStatus("In Progress");

        // Thêm một thành viên mới
        task.attach(member3);

        // Thay đổi trạng thái công việc lần nữa
        System.out.println("\n--- Thay đổi trạng thái công việc lần 2 ---");
        task.setStatus("Done");

        // Gỡ bỏ một thành viên
        task.detach(member1);

        // Thay đổi trạng thái công việc sau khi gỡ bỏ
        System.out.println("\n--- Thay đổi trạng thái công việc lần 3 ---");
        task.setStatus("Deployed");
	}

}
