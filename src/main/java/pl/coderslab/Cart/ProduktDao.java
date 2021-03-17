package pl.coderslab.Cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduktDao {

    public List<Product> getList(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"cukier",1.99));
        productList.add(new Product(2,"mąka",2.15));
        productList.add(new Product(3,"chleb",2.50));
        productList.add(new Product(4,"banany",2.80));
        productList.add(new Product(5,"kakao",4.15));

        return productList;
    }

}
