package com.pms.details;

import java.util.List;
import java.util.Scanner;
import com.pms.client.ProductClient;
import com.ums.dao.impl.ProductDAOImpl;
import com.ums.pojo.Product;

public class ProductDetails {
	Scanner sc = new Scanner(System.in);
	ProductDAOImpl daoImpl = new ProductDAOImpl();

	public void menuDetails() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("       1)Add Product      ");
			System.out.println("       2)View All Product ");
			System.out.println("       3)View Product ");
			System.out.println("       4)Update Product      ");
			System.out.println("       5)Delete Product      ");
			System.out.println("       6)Buy Product      ");
			System.out.println("       7)Exit            ");
			System.out.println("--------------------------");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				daoImpl.addProduct();
				menuDetails();
				break;
			case 2:
				List<Product> productList = daoImpl.viewAllProducts();
				System.out.println("--------------------------------------------");
				System.out.println("  ProductId    ProductName     Quantity     Price");
				System.out.println("--------------------------------------------");
				if (productList != null)
					for (Product p : productList) 
						if (p != null)
							System.out.println(
									p.getPid() + "\t" + p.getPname() + "\t" + p.getQuantity() + "\t" + p.getPrice());
					

				 else
					System.out.println("Stock is Empty");

				menuDetails();
				break;
			case 3:
				System.out.println("Enter product ID");
				Product p = daoImpl.viewProduct(sc.nextInt());
				System.out.println("--------------------------------------------");
				System.out.println("  ProductId    ProductName     Quantity     Price");
				System.out.println("--------------------------------------------");
				if (p != null) {
					System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getQuantity() + "\t" + p.getPrice());
				} else {
					System.out.println("Product does not exist");
				}
				menuDetails();
				break;
			case 4:
				System.out.println("Enter Product ID");
				daoImpl.updateProduct(sc.nextInt());
				break;
			case 5:
				System.out.println("Enter product ID");
				boolean flag = daoImpl.deleteProduct(sc.nextInt());
				if (flag) {
					System.out.println("Id deleted successfullt");
				} else {
					System.out.println("ID does not exist");
				}
				break;
			case 6:
				daoImpl.buyProduct();
				menuDetails();
				break;
			case 7:
				ProductClient.main(null);
				break;
			default:
				System.out.println("Choose the given options");
			}

		}
	}
}
