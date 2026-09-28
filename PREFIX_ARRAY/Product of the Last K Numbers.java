// https://leetcode.com/problems/product-of-the-last-k-numbers/description/

class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {        
        if (num == 0){
            list = new ArrayList<>();
            list.add(1);
        }
        else{
            list.add(list.get(list.size()-1)*num);    
        }
    }
    
    public int getProduct(int k) {
        
        if (k > list.size()-1){
            return 0;
        }
        else {
            return list.get(list.size()-1)/list.get(list.size()-1-k);
        }
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
