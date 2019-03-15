public class Merge {
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort (data, 0, data.length -1);
  }

  private static void mergesort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      return ;
    }
    int mid = hi / 2; //dividing in half
    mergesort (data, lo, mid);
    mergesort (data, mid + 1, hi);
    merge ();
  }

  private static void merge () {
  }
}
