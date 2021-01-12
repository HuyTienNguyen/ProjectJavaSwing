/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qlkh.entities.Category;
import qlkh.entities.Products;

/**
 *
 * @author Windows 10
 */
public class MyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Products> products = new ArrayList<>();
        Products a = new Products("1", "product1");
        Products a1 = new Products("2", "product2");
     // products.add(a);
            //    products.add(a1);

        List<Category> cates = new ArrayList<>();
        Category cate1 = new Category(1, "a");
        cates.add(cate1);
        Map<Category, List<Products>> map = new HashMap<>();
      map.put(cate1, products);
        List<Products> list2 = new ArrayList<>();
        list2 = map.get(cate1);
       
        for (Products list21 : list2) {
            System.out.println(list21);
        }

    }

}
