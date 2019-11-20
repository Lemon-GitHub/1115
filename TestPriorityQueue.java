import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        //优先级队列 默认小堆 优先级最低的先出
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(2);
        queue.offer(1);
        queue.offer(3);
        queue.offer(4);
        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }
}
