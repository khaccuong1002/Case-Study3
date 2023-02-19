package com.codegym.service;

import com.codegym.comparator.ShoePriceComparator;
import com.codegym.entity.Adidas;
import com.codegym.entity.Nike;
import com.codegym.entity.Puma;
import com.codegym.entity.Shoe;
import com.codegym.factory.BrandType;
import com.codegym.factory.ShoeFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShoeService {

    public static final String FILE_DIR_PATH = "/Users/admin/Desktop/Module two/" +
                                                "Case Study/ShoeStore/src/com/codegym/file/";
//    /Users/admin/Desktop/Module two/Case Study/ShoeStore/shoe.txt
    private List<Shoe> shoes;

    Scanner sc = new Scanner(System.in);

    private static ShoeService management = new ShoeService();

    ShoeService(){
        shoes = new ArrayList<>();
    }

    public static ShoeService getManagement(){
        return management;
    }

    public void add(){
        ShoeFactory shoeFactory = new ShoeFactory();
        String type = null;
        System.out.println("Mời bạn nhập hãng giày (NIKE, ADIDAS, PUMA): ");
        type = sc.nextLine();

        while (!isBrandTypeExists(type)){
            System.out.println("Nhãn hàng giày không tồn tại! " +
                    "Vui lòng nhập lại hãng giày (NIKE, ADIDAS, PUMA): ");
            type = sc.nextLine();
        }
        BrandType brandType = BrandType.valueOf(type);
        Shoe addingShoe = shoeFactory.getShoe(brandType);
        shoes.add(addingShoe);
    }

    public Shoe inputShoeInfo(Shoe shoe) {
        System.out.println("Nhập mã ID giày: ");
        shoe.setId(sc.nextLine());

        System.out.println("Nhập tên giày: ");
        shoe.setName(sc.nextLine());

        System.out.println("Nhập size giày: ");
        shoe.setSize(sc.nextDouble());
        sc.nextLine();

        System.out.println("Nhập màu của giày: ");
        shoe.setColor(sc.nextLine());

        System.out.println("Nhập giá: ");
        shoe.setPrice(sc.nextInt());
        sc.nextLine();

        System.out.println("Nhập số lượng :");
        shoe.setQuantity(sc.nextInt());
        sc.nextLine();
        return shoe;
    }

    public boolean isBrandTypeExists(String type){
        for (BrandType brandType: BrandType.values()){
            if (type.equalsIgnoreCase(brandType.name())){
                return true;
            }
        }
        return false;
    }

    public void display(){
        for (Shoe shoe: shoes) {
            System.out.println(shoe);
        }
    }

    public boolean isShoeExists(String id){
        for (Shoe shoe: shoes) {
            if (id == shoe.getId()) return true;
        }
        return false;
    }

    public void searchName(){
        System.out.println("Nhập tên sản phẩm bạn muốn tìm: ");
        String name = sc.nextLine();
        for (Shoe shoe: shoes) {
            if (shoe.getName().equalsIgnoreCase(name)){
                System.out.println(shoe);
            }
        }
    }

    public Shoe searchId(String id){
        sc.nextLine();
        for (Shoe shoe: shoes) {
            if (id == shoe.getId()) return shoe;
        }
        return null;
    }

    public void remove(){
        System.out.println("Mời bạn nhập ID để xoá: ");
        String idShoe = sc.nextLine();
        if (isShoeExists(idShoe)) {
            Shoe shoe = searchId(idShoe);
            shoes.remove(shoe);
        } else {
            System.out.println("ID không tồn tại !");
        }
    }

    public void edit() {
        System.out.println("1.Mời bạn nhập ID muốn sửa thông tin sản phẩm:");
        String id = sc.nextLine();
        System.out.println("2.Nhập tên giày muốn sửa: ");
        String name = sc.nextLine();
        System.out.println("3.Nhập size giày muốn sửa: ");
        double size = sc.nextDouble();
        sc.nextLine();
        System.out.println("4.Nhập màu giày muốn sửa: ");
        String color = sc.nextLine();
        System.out.println("5.Nhập giá muốn sửa: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.println("6.Nhập số lượng muốn sửa: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (isShoeExists(id)) {
            Shoe shoe = searchId(id);
            shoe.setName(name);
            shoe.setSize(size);
            shoe.setColor(color);
            shoe.setPrice(price);
            shoe.setQuantity(quantity);
        } else {
            System.out.println("ID không tồn tại !");
        }
    }

    public void sort(){
        ShoePriceComparator shoePriceComparator = new ShoePriceComparator();
        Collections.sort(shoes, shoePriceComparator);
        display();
    }

    public void saveToFile(){
        try {
            FileWriter fileWriter = new FileWriter(FILE_DIR_PATH + "shoe.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Shoe shoe : shoes) {
                bufferedWriter.write(shoe.toFile());
                bufferedWriter.newLine();
            }
            System.out.println("Lưu file thành công !");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFile(){
        shoes.clear();
        try {
            FileReader fileReader = new FileReader(FILE_DIR_PATH + "shoe.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Shoe shoe = handleLine(line);
                shoes.add(shoe);
                System.out.println(shoe);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    private Shoe handleLine(String line){
        String[] strings = line.split(",");
        if (checkBrandType(strings[0])== "ADIDAS"){
            return new Adidas.AdidasBuilder()
                    .id(strings[0])
                    .name(strings[1])
                    .size(Double.parseDouble(strings[2]))
                    .color(strings[3])
                    .price(Integer.parseInt(strings[4]))
                    .quantity(Integer.parseInt(strings[5])).build();
        } else if (checkBrandType(strings[0])== "NIKE") {
            return new Nike.NikeBuilder()
                    .id(strings[0])
                    .name(strings[1])
                    .size(Double.parseDouble(strings[2]))
                    .color(strings[3])
                    .price(Integer.parseInt(strings[4]))
                    .quantity(Integer.parseInt(strings[5])).build();
        } else if (checkBrandType(strings[0])== "PUMA"){
            return new Puma.PumaBuilder()
                    .id(strings[0])
                    .name(strings[1])
                    .size(Double.parseDouble(strings[2]))
                    .color(strings[3])
                    .price(Integer.parseInt(strings[4]))
                    .quantity(Integer.parseInt(strings[5])).build();
        }
        return null;
    }

    public String checkBrandType(String shoeId){
        if (shoeId.startsWith("A")){
            return "ADIDAS";
        }
        if (shoeId.startsWith("N")){
            return "NIKE";
        }
        if (shoeId.startsWith("P")){
            return "PUMA";
        }
        return null;
    }


}
