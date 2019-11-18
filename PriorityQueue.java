public class PriorityQueue {
    //这个数组是队列本体，基于数组建堆
    private int[] array = new int[100];
    //队列元素个数
    private int size = 0;
    public void offer(int x) {
        if(size >= array.length) {
            return;
        }
        array[size] = x;
        size++;
        shiftUp(array, size - 1); //需要向上调整的节点的位置
    }

    //复杂度O(logN)
    private void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (index - 1) / 2;
        while(child > 0) {
            if(array[parent] < array[child]){
                //swap
                swap(array, child, parent);
            }else {
                break;//调整结束
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void shiftDown(int[] array,int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while(child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //此时child指向左右子树的最大值

            if(array[parent] < array[child]) {
                //不满足大堆
                swap(array, parent, child);
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }


    //删除堆顶元素 用最后一个元素覆盖堆顶元素 最后进行向下调整
    public Integer poll() {
        if(size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return ret;

    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        int ret = array[0];
        return ret;
    }
}
