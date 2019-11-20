import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestTopK {
    // 普通的类无法放入优先级队列中  可以吧当前的类实现comparable接口
    // 并且实现compareTo决定谁的优先级高
    static class Pair implements Comparable<Pair> {
        public int n1;
        public int n2;
        public int sum;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }

        @Override
        public int compareTo(Pair o) {
            // this other
            // 如果希望 this在前 other在后  < 0
            //                           > 0
            // 相等 返回 0
            if(this.sum < o.sum) {
                return 1;
            }
            if(this.sum > o.sum) {
                return -1;
            }
            return 0;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k < 1) {
            return result;
        }
        //创建优先队列 通过优先队列作为堆
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(int i = 0; i < nums1.length && i < k; i++) {
            for(int j = 0; j < nums2.length && j < k; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
                if(queue.size() > k) {
                    //始终保证 队列中 不超过k个元素
                    queue.poll();
                }
            }
        }
        //双循环结束 queue保存需要的k对数字
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(pair.n1);
            tmp.add(pair.n2);
            // 每次出队列的值插入result最前面
            result.add(0,tmp);
        }
        return result;
    }
}
