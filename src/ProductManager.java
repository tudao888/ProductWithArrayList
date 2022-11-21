import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    List<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void add() {
        Product newProduct = createProduct();
        productList.add(newProduct);
    }

    public Product createProduct() {
        int id;
        String name;
        double price;
        System.out.println("Nhập vào id sản phẩm: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sản phẩm: ");
        name = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm: ");
        price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        return product;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void edit() {
        System.out.println("Nhập vào ID sản phẩm muốn tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm!");
        } else {
            Product newProduct = createProduct();
            productList.set(index, newProduct);
        }
    }

    public void delete() {
        System.out.println("Nhập vào ID sản phẩm muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm!");
        } else {
            productList.remove(index);
        }
    }

    public void show() {
        for (Product valueProduct : productList) {
            System.out.println(valueProduct.toString());
        }
    }

    public void findProductByName() {
        String name;
        System.out.println("Nhập vào tên sản phẩm muốn tìm kiếm: ");
        name = scanner.nextLine();
        for (Product nameProduct : productList) {
            if (nameProduct.getName().equals(name)) {
                System.out.println(nameProduct.toString());
                break;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    public void sortByIncreasingPrice() {
        for (int i = 0; i < productList.size(); i++) {
            int indexMax = i;
            for (int j = i + 1; j < productList.size(); j++) {
                if (productList.get(j).getPrice() > productList.get(indexMax).getPrice()) {
                    indexMax = j;
                }
                Product temp = productList.get(i);
                productList.set(i, productList.get(indexMax));
                productList.set(indexMax, temp);
            }
        }
    }

    public void IncreasingPrice() {
        sortByIncreasingPrice();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void DecreasingPrice() {
        sortByDecreasingPrice();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    private void sortByDecreasingPrice() {
        productList.sort(Product::compareTo);
    }
}
