package ca.nbcc.shoppinglist;

import java.util.HashMap;

public class Model {
    // a simple hashMap declaration with default size and load factor
    HashMap<String, Integer> shoppingCart = new HashMap<String, Integer>();

    public void addItem(String product){
        if(!shoppingCart.containsKey(product)){
            shoppingCart.put(product, 1);
        }else{
            Integer oldAmt = shoppingCart.get(product);
            shoppingCart.replace(product, oldAmt, oldAmt + 1);
        }
    }

    public String sendShoppingCart(){
        String finalCart = "";

        for (String key : shoppingCart.keySet()) {
            Integer value = shoppingCart.get(key);
            finalCart += key + " " + Integer.toString(value) + "\n";
        }
        return  finalCart;
    }

    public void getShoppingCart(String cart){
        for(String keyValue : cart.split("\n")) {
            String[] pairs = keyValue.split(" ", 2);
            shoppingCart.put(pairs[0], 1);

        }
    }
}

