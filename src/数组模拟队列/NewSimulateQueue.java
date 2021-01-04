package 数组模拟队列;

public class NewSimulateQueue {
    public static void main(String[] args) {
        NewSimulateQueue.ArrayQueue array = new NewSimulateQueue.ArrayQueue(10);
        for (int i=0; i<8 ;i++){
            array.AddArray(i);
        }
        if (array.FullArray()){
            System.out.println("队列已满");
        }else{
            System.out.println("队列未满");
        }
        if (array.NullArray()){
            System.out.println("队列为空");
        }else {
            System.out.println("队列不为空");
        }
        array.AddArray(13);
        array.ShowArray();
        array.ShowHeadArray();
        System.out.println("队列中有效的数据个数为"+array.size());
        array.GetArray();
        if (array.NullArray()){
            System.out.println("队列为空");
        }
        System.out.println();
    }
    //1.使用数组模拟队列——编写一个ArrayQueue类
    static class ArrayQueue{
        int maxSize;   //1）：表示队列的最大容量
        int font;  //2）：队列头
        int rear;  //3）：队列尾
        int array [];  //4）：创建一个数组存入数据，模拟队列
        //2.创造队列的构造器
        public ArrayQueue(int ArrayMacSize){
            maxSize = ArrayMacSize;  //存放数组最大容量
            array = new int[maxSize];  //初始化模拟数组对象
            font = 0;  //1）：就指向队列的第一个元素，也就是说队列的第一个元素
            rear = 0;  //2）：rear指向队列的最后一个元素的后一个元素，因为希望空出作一个约定
        }
        //3.判断队列是否为满
        public boolean FullArray(){
            return ((rear+1)%maxSize)==font;
        }
        //4.判断队列是否为空
        public boolean NullArray(){
            return (font==rear);
        }
        //5.添加队列数据
        public void AddArray(int data){
            //判断队列是否为满
            if (FullArray()){
                //抛出异常
//                throw new RuntimeException("队列已满，不能再添加数据");
                System.out.println("队列已满，不能再添加数据");
            }else {
                  array[rear]=data;  //rear从0开始，故因此，下一个位置就是下标为rear
                  rear = (rear+1)%maxSize;  //因为为环形的数组队列，下一个所指的下标为
            }
        }
        //6.获取队列数据，（出队列）
        public void GetArray(){
            //判断队列是否为空
            if (NullArray()){
                throw new RuntimeException("队列为空，没有数据可以输出");
            }else {
                System.out.println("\n队列中的数据为：");
                while (font!=rear){
                   System.out.println("array["+font+"]="+array[font]+"\t");
                    font = (font+1)%maxSize;
                }
                System.out.println();
            }
        }
        //7.显示所有数据
        public void ShowArray(){
            //判断队列是否为空
            if(NullArray()){
                throw new RuntimeException("队列为空，没有任何数据");
            }else {
                System.out.println("显示队列所有数据为：");
                for (int i = font; i < font+size(); i++){
                    System.out.print("array["+i%maxSize+"]="+array[(i%maxSize)]+"\t");
                }
                System.out.println("有效数据："+size());
            }
        }
        //8.显示队列头数据
        public void ShowHeadArray(){
            //判断队列是否为空
            if(NullArray()){
                throw new RuntimeException("队列为空，没有任何数据输出");
            }else {
                System.out.print("队列的头数据为："+array[font]+"\t");
            }
            System.out.println();
        }
        //9.获取队列有效数据的个数
        public int size(){
            return ((rear+maxSize-font)%maxSize);
        }
    }
}
