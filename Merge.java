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
    int ans = new int [one.length + another.length];
    int len = Math.min (one.length, another.length);
    int index = 0;
    for (int i = 0; i < len; i ++) {
      int o = one[i];
      int a = another[i]; 
    }
    return ans;
  }
}
