public class DecToBin {
    

    public static void convertInteger(int x){
        Stack<Integer> bin = new Stack<>();
        while(x != 0){
            bin.push(x % 2);
            x /= 2;
        }
        bin.print();
    }

    public static void convertLessThanOne(double x){
        Queue<Integer> bin = new Queue<>();
        if(x < 1){
            while(x - Math.floor(x) != 0.0){
                x *= 2;
                bin.enqueue((int)Math.floor(x));
                x -= Math.floor(x);
            }
        }
        bin.print();
    }
}
