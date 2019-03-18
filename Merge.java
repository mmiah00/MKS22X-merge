public class Merge {
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort (data, 0, data.length -1);
  }

  private static int[] mergesort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      return data;
    }
    int mid = hi / 2; //dividing in half
    return merge (mergesort (data, lo, mid), mergesort (data, mid + 1, hi));
  }

  private static int[] merge (int [] one, int[] another) {
    int[] ans = new int [one.length + another.length];
    int o = 0;
    int a = 0;
    for (int i =0 ; i < one.length + another.length; i ++) {
      if (one[o] <= another[a]) {
        ans[i] = one[o];
        o ++;
      }
      else {
        ans[i] = another[a];
        a ++;
      }
    }
    return  ans;
  }

  public static String toString (int[] x) {
    String ans = "[";
     for (int i = 0; i < x.length; i ++) {
       if (i != x.length - 1) {
         ans += x[i] + " ";
       }
     }
    return ans + "]";
  }

  public static void main (String[] args) {
    int[] test = {2,3,7,3,2,6,8,4};
    int[] b = {1,2,3,4};

    System.out.println (merge (test, b));
  }
}
