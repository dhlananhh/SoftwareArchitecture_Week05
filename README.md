# Software Architecture Practice Exercises - Week 5

## Submission Information

- **Full Name**: Dương Hoàng Lan Anh
- **Student ID**: 21087481

---

## A> Design Patterns Application - Week 5:

### Exercise 1: File and folder management system

**Bài toán**: Xây dựng hệ thống quản lý thư mục và tập tin theo mô hình cây, với các yêu cầu:

- Thư mục có thể chứa nhiều tập tin hoặc thư mục con.
- Tập tin chỉ chứa dữ liệu, không chứa thư mục/tập tin khác.
- Cả thư mục và tập tin đều có thể được hiển thị thông tin.

**Sơ đồ UML:**

![File System UML](proof_images/Exercise01_FileSystem_UMLDiagram.png)

**Giải thích về lựa chọn Design Pattern (Composite Pattern) cho bài toán này:**

Composite Design Pattern là một lựa chọn phù hợp cho bài toán này vì những lý do sau:

- **Mô hình hóa cấu trúc cây:** Theo định nghĩa, Composite Pattern tổ chức các đối tượng theo cấu trúc phân cấp dạng cây để biểu diễn mối quan hệ "một phần - toàn bộ" (part-whole hierarchies). Trong bài toán này, một thư mục có thể chứa các tập tin (phần) hoặc các thư mục con (cũng là một "toàn bộ" có thể chứa các "phần" khác), tạo nên một cấu trúc cây rõ ràng.

- **Xử lý thống nhất đối tượng đơn lẻ và đối tượng phức tạp:** Composite Pattern cho phép client (phần sử dụng các đối tượng) xử lý các đối tượng riêng lẻ (Leaf - tập tin) và các đối tượng chứa các đối tượng khác (Composite - thư mục) một cách đồng nhất thông qua một interface chung (Component). Điều này có nghĩa là ta có thể gọi phương thức hiển thị thông tin trên một tập tin cũng như trên một thư mục (mà nó sẽ tự động hiển thị thông tin của tất cả các thành phần bên trong nó).

- **Tính tổng quát hóa:** Client có thể xem đối tượng bao gộp và bị bao gộp như nhau, tăng khả năng tổng quát hóa trong code của client, giúp dễ phát triển, nâng cấp và bảo trì.

- **Xử lý một nhóm đối tượng tương tự như một đối tượng:** Composite Pattern được sử dụng khi cần xử lý một nhóm đối tượng tương tự theo cách xử lý 1 object. Trong trường hợp này, một thư mục (nhóm các tập tin và thư mục con) có thể được xem và thao tác như một thực thể duy nhất.

- **Lợi ích theo nguồn:** Cung cấp cùng một cách sử dụng đối với từng đối tượng riêng lẻ hoặc nhóm các đối tượng với nhau.

**Kết quả:**

![File System Demo](proof_images/Exercise01_FileSystemDemo.png)

---

### Exercise 2: Stock/job status change notification system

**Bài toán**: Hệ thống cần thông báo cho các nhà đầu tư/thành viên nhóm khi có thay đổi giá cổ phiếu/trạng thái công việc.

**Sơ đồ UML:**

![Stock Market UML](proof_images/Exercise02_StockMarket_UMLDiagram.png)

**Giải thích về lựa chọn Design Pattern (Observer Pattern) cho bài toán này:**

- Trong bài toán của bạn, cổ phiếu đóng vai trò là Subject, trạng thái của nó là giá. Các nhà đầu tư đã đăng ký theo dõi là các Observers. Khi giá cổ phiếu thay đổi (trạng thái của Subject thay đổi), tất cả các nhà đầu tư đã đăng ký (Observers) cần được thông báo ngay lập tức về sự thay đổi này [theo yêu cầu của bài toán].

- Observer Pattern rất phù hợp với tình huống này vì những lý do sau:

    - **Tách rời các đối tượng:** Observer Pattern cho phép bạn thay đổi Subject và Observer một cách độc lập. Cổ phiếu không cần biết chi tiết về từng nhà đầu tư, nó chỉ cần biết danh sách các đối tượng cần thông báo khi giá thay đổi. Tương tự, mỗi nhà đầu tư chỉ cần biết về cổ phiếu mà họ đang theo dõi và cách nhận thông báo, không cần biết về các nhà đầu tư khác.

    - **Dễ dàng mở rộng:** Bạn có thể thêm bất kỳ số lượng nhà đầu tư nào muốn theo dõi cổ phiếu mà không cần sửa đổi lớp Stock (Subject). Chỉ cần thêm chúng vào danh sách các Observers. Điều này tuân theo nguyên tắc Open/Closed Principle (OCP).

    - **Quản lý sự kiện:** Observer Pattern thường được sử dụng để quản lý sự kiện. Sự thay đổi giá cổ phiếu có thể được coi là một sự kiện, và các nhà đầu tư là những người quan tâm đến sự kiện này.

    - **Loại bỏ sự phụ thuộc chặt chẽ:** Thay vì cổ phiếu phải trực tiếp gọi phương thức thông báo trên từng nhà đầu tư, Observer Pattern sử dụng một cơ chế đăng ký và thông báo, giúp giảm sự phụ thuộc giữa các lớp.

**Kết quả:**

![Stock Market Demo](proof_images/Exercise02_StockMarketDemo.png)

---

### Exercise 3: Convert XML data format to JSON and vice versa

**Bài toán**: Dịch vụ web yêu cầu JSON, hệ thống khác chỉ hỗ trợ XML. Viết adapter để chuyển đổi XML <-> JSON.

**Sơ đồ UML:**

![XML JSON Converter UML](proof_images/Exercise03_DataFormatConverter_UMLDiagram.png)

**Giải thích về lựa chọn Design Pattern (Adapter Pattern) cho bài toán này:**

- **Giải quyết sự không tương thích giữa các interface:** Yêu cầu đặt ra là một dịch vụ web yêu cầu dữ liệu ở định dạng JSON, trong khi một hệ thống khác chỉ hỗ trợ dữ liệu ở định dạng XML. Đây là tình huống điển hình về sự không tương thích giữa hai interface khác nhau. Adapter Pattern được thiết kế để chuyển đổi interface của một lớp thành một interface khác mà client mong đợi.

- **Cho phép các interface không liên quan làm việc cùng nhau:** Adapter Pattern cho phép các interface (trong trường hợp này là cách biểu diễn dữ liệu XML và JSON) không liên quan tới nhau có thể làm việc cùng nhau. Adapter sẽ đóng vai trò trung gian để kết nối và chuyển đổi dữ liệu giữa hai định dạng này.

- **Tái sử dụng lớp đã tồn tại:** Hệ thống hỗ trợ XML đã tồn tại và chúng ta không muốn hoặc không thể thay đổi interface của nó. Adapter Pattern cho phép chúng ta sử dụng lại thư viện với interface không thay đổi do không có mã nguồn bằng cách tạo một lớp Adapter "bọc ngoài" (Wrapper Pattern) để chuyển đổi dữ liệu cho phù hợp với yêu cầu của dịch vụ web mới.

- **Đảm bảo nguyên tắc Open/Closed:** Việc sử dụng Adapter Pattern giúp tuân thủ nguyên tắc Open/Closed, nghĩa là chúng ta có thể mở rộng khả năng tương tác với các định dạng dữ liệu mới trong tương lai bằng cách tạo thêm các Adapter mới mà không cần sửa đổi code của các hệ thống hiện có (dịch vụ web JSON và hệ thống XML).

- **Tránh thay đổi code của các lớp hiện có:** Adapter Pattern cho phép các lớp có các interface khác nhau có thể dễ dàng giao tiếp tốt với nhau thông qua interface trung gian, không cần thay đổi code của lớp có sẵn cũng như lớp đang viết.

**Kết quả:**

![XML JSON Converter Demo](proof_images/Exercise03_DataFormatConverterDemo.png)

---

## B> Extra Exercise: Library Management System using Design Patterns

**Sơ đồ UML:**

![Library Management UML](proof_images/LibraryManagementSystem_UMLDiagram.png)
