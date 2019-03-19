public class Merge {
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort (data, 0, data.length -1);
  }

  private static int[] mergesort (int[] data, int lo, int hi) {
    int mid = hi / 2; //dividing in half
    if (lo >= hi) {
      int[] ans = {data[lo]};
      return ans; 
      //return merge (mergesort (data, lo, mid + 1), mergesort (data, mid + 1, hi + 1));
    }
    //return mergesort  (data, lo, mid +1);
    //mergesort (data, mid + 1, hi + 1);
    return merge (mergesort (data, lo, mid), mergesort (data,mid + 1, hi));
  }

  private static int[] merge (int [] one, int[] another) {
    int[] ans = new int [one.length + another.length ];
    int i = 0; //keeps track of numbers you are adding to ans
    int o = 0; //keeps track of index of int[] one
    int a = 0; //keeps track of index of int[] another
    while (i < ans.length) {
      try {
        //if you reach the end of the shorter list, add the trailing values of the longer list to the answer
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

        //add the greater value to the answer
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
       else {
         ans += x[i];
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
    int[] e = {1,2,3,4,5,6};
    int[] f = {7,8,9,10,11};

    System.out.println (toString (merge (a, b)));
    System.out.println (toString (merge (c, d)));
    System.out.println (toString (merge (e, f)));
  }
}
