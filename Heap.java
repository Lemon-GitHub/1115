import java.util.Arrays;

public class Heap {
    //array中 [0, size)的部分是一个堆
    //从index位置下沉
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size) {
            //找左子树和右子树谁更大
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //此时下标child的元素一定是左右子树最大的元素
            if(array[child] > array[parent]) {
                //不符合大堆的性质 交换
                swap(array, child, parent);
            }else{
                //符合大堆性质
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    //将[0, size) 范围的元素建成堆
    public static void createHeap(int[] array, int size) {
        //从最后一个非叶子结点出发，从后往前走，针对每个节点进行向下调整
        //最后一个元素的下标 size - 1
        //最后一个元素的父节点下标 （size - 1 - 1）/ 2
        for(int i = (size - 1 - 1) / 2 ; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
