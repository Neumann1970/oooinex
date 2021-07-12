package task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class SumTask {

    private static HashSet<Integer> duplications = new HashSet<>();
    public static void main(String[] args) {
        int[] arr = {1,2,3,8,8,9,9,4,6,6,1,2,4,4,4,4,4,90,6,6,6,6,6,6,2,1,1,2,2};
        int[] findDupsAndMultIt = Arrays.stream(arr).filter(i->!duplications.add(i)).map(i->i+=i).toArray();

        findDupsAndMultIt = arrDistinct(findDupsAndMultIt);
        arr = arrDistinct(arr);

        int counter = 0;
        int[] sum = new int[(int)(arr.length*((double)arr.length/2-0.5))];
        for(int i = 0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                sum[counter] = arr[i]+arr[j];
                counter++;
            }
        }
        int[] result = arrDistinct(IntStream.concat(IntStream.of(sum), IntStream.of(findDupsAndMultIt)).toArray());
        System.out.println(Arrays.toString(result));
    }
    private static int[] arrDistinct(int[] arr){
        duplications.clear();
        return IntStream.of(arr).filter(i->duplications.add(i)).toArray();
    }
}
