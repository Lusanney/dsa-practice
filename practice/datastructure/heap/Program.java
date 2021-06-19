import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int lastParent = (int) Math.floorDiv(array.size() - 2, 2);
                
            for(int currentIdx = lastParent; currentIdx >= 0; currentIdx--){
                siftDown(currentIdx, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, List<Integer> heap) {
            int childOne = currentIdx * 2 + 1;
            int childTwo = currentIdx * 2 + 2;
            
            int toSwap = currentIdx;
            
            if(childOne < heap.size() && heap.get(childOne) < heap.get(toSwap))
                toSwap = childOne;
            
            if(childTwo < heap.size() && heap.get(childTwo) < heap.get(toSwap))
                toSwap = childTwo;
            
            if(toSwap != currentIdx){
                swap(currentIdx, toSwap, heap);
                siftDown(toSwap, heap);
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (int) Math.floorDiv(currentIdx - 1, 2);
                
            while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)){
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (int) Math.floorDiv(currentIdx - 1, 2);
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int value = heap.get(0);
            
            // Choose a leaf to be the head, and then sift it down
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            
            siftDown(0, heap);
            return value;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
		
        private void swap(int idxX, int idxY, List<Integer> heap){
            int temp = heap.get(idxX);
            heap.set(idxX, heap.get(idxY));
            heap.set(idxY, temp);
        }
    }
}
