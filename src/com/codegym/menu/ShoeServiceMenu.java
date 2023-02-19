package com.codegym.menu;

import com.codegym.service.ShoeService;

import java.util.Scanner;

public class ShoeServiceMenu {
    public ShoeServiceMenu(){}

    ShoeService shoeService = ShoeService.getManagement();

    Scanner sc = new Scanner(System.in);

    public void getMenu(){
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------MENU--------");
            System.out.println("1. Thêm thông tin giày");
            System.out.println("2. In danh sách");
            System.out.println("3. Xoá sản phẩm ");
            System.out.println("4. Tìm sản phẩm ");
            System.out.println("5. Cập nhật sản phẩm");
            System.out.println("6. Sắp xếp theo giá");
            System.out.println("7. Đọc File");
            System.out.println("8. Ghi File");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: shoeService.add();
                break;
                case 2: shoeService.display();
                break;
                case 3: shoeService.remove();
                break;
                case 4: shoeService.searchName();
                break;
                case 5: shoeService.edit();
                break;
                case 6: shoeService.sort();
                break;
                case 7: shoeService.readFromFile();
                break;
                case 8: shoeService.saveToFile();
                break;
                default:
                    System.out.println("Lựa chọn của bạn không tìm thấy");
            }
        } while (choice != 0);
    }

}
