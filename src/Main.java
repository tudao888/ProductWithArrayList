import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        String menu = "1. Thêm sản phẩm\n" +
                "2. Sửa thông tin sản phẩm theo id\n" +
                "3. Xoá sản phẩm theo id\n" +
                "4. Hiển thị danh sách sản phẩm\n" +
                "5. Tìm kiếm sản phẩm theo tên\n" +
                "6. Sắp xếp sản phẩm theo giá giảm dần\n" +
                "7. Sắp xếp sản phẩm theo giá tăng dần\n" +
                "8. Thoát\n" +
                "Nhập vào lựa chọn của bạn: ";
        while (true) {
            System.out.println(menu);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.edit();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    productManager.show();
                    break;
                case 5:
                    productManager.findProductByName();
                    break;
                case 6:
                    productManager.IncreasingPrice();
                    break;
                case 7:
                    productManager.DecreasingPrice();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }

        }
    }
}