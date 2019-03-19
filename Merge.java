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
    int[] ans = new int [one.length + another.length + 1];
    /*
    int o = 0;
    int a = 0;
    int i = 0;
    while (o < one.length && a < another.length) {
      if (one[o] <= another[a]) {
        ans[i] = one[o];
        i ++;
        o ++;
      }
      else {
        ans[i] = another[a];
        i ++;
        a ++;
      }
    } //doesnt fill everything
    */

    int i = 0;
    int o = 0;
    int a = 0;
    while (i < ans.length) {
      try {
        if (o >= one.length) {
          for (int x = a; x < ans.length; x ++) {
            ans[i] = another[x];
            i ++;
          }
        }
        if (a >= another.length) {
          for (int x = o; x < ans.length; x ++) {
            ans[i] = one[x];
            i ++;
          }
        }
        if (one[o] <= another[a]) {
          ans[i] = one[o];
          i ++;
          o ++;
        }
        else {
          ans[i] = another[a];
          i ++;
          a ++;
        }
      }
      catch (IndexOutOfBoundsException e) {

      }
    }

    return ans;
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
    int[] a = {2,3,5,7,8,8,9};
    int[] b = {1,2,3,4};
    int[] c = {3,5,8,9,11,12};
    int[] d = {2,7,9,18};

    System.out.println (toString (merge (a, b)));
    System.out.println (toString (merge (c, d)));
  }
}
