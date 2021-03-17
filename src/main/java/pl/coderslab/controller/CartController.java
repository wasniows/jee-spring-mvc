package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Cart.Cart;
import pl.coderslab.Cart.CartItem;
import pl.coderslab.Cart.Product;
import pl.coderslab.Cart.ProduktDao;
import java.time.LocalDateTime;

@Controller
public class CartController {

    private Cart cart;
    private ProduktDao produktDao;

    @Autowired
    public CartController(Cart cart, ProduktDao produktDao) {
        this.cart = cart;
        this.produktDao = produktDao;
    }


    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam long id, @RequestParam int quantity){

        Product product = new Product();
        for (Product elem : produktDao.getList()){
            if (elem.getId() == id){
                product = elem;
            }
        }
        for (CartItem elem : cart.getCartItems()){
            if (elem.getProduct().getId() == product.getId()){
                elem.setQuantity(quantity + elem.getQuantity());
                return "increase quantity " + LocalDateTime.now();
            }
        }

        cart.addToCart(new CartItem(quantity,product));

        return "added product to cart " + LocalDateTime.now();
    }

    @GetMapping(path = "/cart", produces = "text/html; charset=UTF-8")
    @ResponseBody

    public String getCart(){
        double sum = 0;
        int quantity = 0;
        for(CartItem elem : cart.getCartItems()){
            quantity += elem.getQuantity();
            sum += elem.getQuantity()*elem.getProduct().getPrice();
        }

        return String.format("W koszyku jest %s pozycji." + "<br>"+
                "W koszyku jest %s produktów." + "<br>" +
                "Wartość koszyka to: %s",
                cart.getCartItems().size(),
                quantity,
                sum
                );
    }
}
