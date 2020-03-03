public class Main {

    public static void main(String[] args) {
	// write your code here
        //开辟空间
//        int[] arr=new int[10];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=i;
//        }
//        int[] scores=new int[]{100,99,66};
//        for(int i=0;i<scores.length;i++){
//            System.out.println(scores[i]);
//        }
//
//        scores[0]=98;
//
//        for(int score: scores){
//            System.out.println(score);
//        }
        Array<Integer> arr = new Array<>();
        //泛型中不能存放基本数据类型：boolean byte char short int long float double
        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.print(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
    }
}
