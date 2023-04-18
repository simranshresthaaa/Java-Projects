package com.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ums.dao.ProductDao;
import com.ums.pojo.Product;

public class ProductDAOImpl implements ProductDao {
	Scanner sc = new Scanner(System.in);
	ArrayList<Product> addProduct = new ArrayList<>();
	List<Product> productList = new ArrayList<>();

	@Override
	public void addProduct() {
		int k = 1;
		while (k == 1) {
			System.out.println("Enter product ID: ");
			int pid = sc.nextInt();
			System.out.println("Enter product name: ");
			String pname = sc.next();
			System.out.println("Enter product quantity: ");
			int quantity = sc.nextInt();
			System.out.println("Enter product price: ");
			int price = sc.nextInt();
			Product product = new Product(pid, pname, quantity, price);
			addProduct.add(product);
			System.out.println("Product added ");
			System.out.println("Do you want to add more products 1)Yes 2)No");
			k = sc.nextInt();
		}
	}

	@Override
	public List<Product> viewAllProducts() {
		for (Product product : addProduct) {
			productList.add(product);
		}
		return productList;
	}

	@Override
	public Product viewProduct(int pid) {
		if (productList != null) {
			for (Product pro : productList) {
				if (pro != null) {
					if (pro.getPid() == pid) {
						return pro;
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int pid) {
		Product delete = null;
		for (Product pro : addProduct) {
			if (pro.getPid() == pid) {
				delete = pro;
				break;
			}
		}
		if (delete != null) {
			addProduct.add(delete);
			return true;

		} else {

			return false;

		}
	}

	@Override
	public void updateProduct(int pid) {
		Product update = null;
		for (Product pro : addProduct) {
			if (pro.getPid() == pid) {
				update = pro;
				break;
			}
		}
		if (update != null) {
			System.out.println("Which field would you like to update");
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Quantity");
			System.out.println("4. Price");
			System.out.println("5. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter new ID");
				int newPid = sc.nextInt();
				update.setPid(newPid);
				break;
			case 2:
				System.out.println("Enter new name");
				String newName = sc.next();
				update.setPname(newName);
				break;
			case 3:
				System.out.println("Enter new quantity");
				int newQty = sc.nextInt();
				update.setQuantity(newQty);
				break;
			case 4:
				System.out.println("Enter new price");
				int newPrice = sc.nextInt();
				update.setPrice(newPrice);
				break;
			case 5:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Choose between 1 to 5");
				break;

			}
		} else {
			System.out.println("Product not found");
		}
	}

	@Override
	public void buyProduct() {
	    System.out.println("Available products:");
	    for (Product product : addProduct) {
	        System.out.println(product);
	    }
	    System.out.println("Enter the product ID you want to buy:");
	    int pid = sc.nextInt();
	    Product productToBuy = null;
	    for (Product product : addProduct) {
	        if (product.getPid() == pid) {
	            productToBuy = product;
	            break;
	        }
	    }
	    if (productToBuy != null) {
	        System.out.println("Enter the quantity you want to buy:");
	        int quantity = sc.nextInt();
	        if (productToBuy.getQuantity() < quantity) {
	            System.out.println("Insufficient quantity");
	        } else {
	            productToBuy.setQuantity(productToBuy.getQuantity() - quantity);
	            System.out.println("Purchase successful");
	        }
	    } 
	    else {
	        System.out.println("Product not found");
	    }
	}
}