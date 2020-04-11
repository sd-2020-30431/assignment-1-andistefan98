package bean;

import java.util.*;

/**
 * 
 */
public class CartBean {

    /**
     * Default constructor
     */
    public CartBean() {
    }

    /**
     * 
     */
    private ArrayList alCartItems;

    /**
     * 
     */
    private double dblOrderTotal;

    /**
     * @return
     */
    public int getLineItemCount() {
        // TODO implement here
        return 0;
    }

    /**
     * @param strItemIndex 
     * @return
     */
    public void deleteCartItem(String strItemIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param strItemIndex 
     * @param strQuantity 
     * @return
     */
    public void updateCartItem(String strItemIndex, String strQuantity) {
        // TODO implement here
        return null;
    }

    /**
     * @param strModelNo 
     * @param strDescription 
     * @param strUnitCost 
     * @param strQuantity 
     * @return
     */
    public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity) {
        // TODO implement here
        return null;
    }

    /**
     * @param cartItem 
     * @return
     */
    public void addCartItem(CartItem cartItem) {
        // TODO implement here
        return null;
    }

    /**
     * @param iItemIndex 
     * @return
     */
    public CartItem getCartItem(int iItemIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList getCartItems() {
        // TODO implement here
        return null;
    }

    /**
     * @param alCartItems 
     * @return
     */
    public void setCartItems(ArrayList alCartItems) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public double getOrderTotal() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param dblOrderTotal 
     * @return
     */
    public void setOrderTotal(double dblOrderTotal) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    protected double calculateOrderTotal() {
        // TODO implement here
        return 0.0d;
    }

}