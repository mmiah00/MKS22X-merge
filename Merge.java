public class Merge {
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort (data, 0, data.length - 1);
  }

  private static void mergesort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      return ;
    }
    int mid = (lo + hi) / 2 - 1;
    mergesort (data, lo, mid);
    mergesort (data, mid + 1, hi);
    merge (data, lo, mid, hi);
  }

  private static void merge (int[] data, int lo, int middle, int hi) {
    int[] left = new int[middle - lo + 1];
    for (int i = 0; i < left.length; i ++) {
      left[i] = data[lo + i];
    }
    int[] right = new int [hi  - middle];
    for (int i =0 ; i < right.length; i ++){
      right [i] = data[middle + i + 1];
    }

    int[] ans = merge (left, right);
    int index = 0;
    for (int i = lo; i < lo + ans.length; i++) {
      data [i] = ans [index];
      index ++;
    }
    System.out.println (toString (data));
   }

  /*
  private static void merge (int[] data, int lo, int middle, int hi) {
    System.out.println ("Data: " + toString (data) + "\nlo: " + data[lo] + "\nmiddle: " + data[middle] + "\nend: " + data[hi]);
    int[] ans = new int[hi - lo + 1];
    int i = 0; //keeping track of index in data
    int left = lo; //keeping track of left side
    int right = middle;
    while (i < ans.length) {
      if (left > middle) {
        for (int x = right; x < ans.length; x ++) {
          int temp = data[x];
          ans[i] = temp;
          i ++;
        }
      }

      if (right > hi) {
        for (int x = left; x < ans.length; x ++) {
          int temp = data[x];
          ans[i] = temp;
          i ++;
        }
      }

      if (data[left] <= data[right]) {
        int temp = data[left];
        ans[i] = temp;
        i ++;
        left ++;
      }
      else {
        int temp = data[right];
        ans[i] = temp;
        i ++;
        right ++;
      }
    }

    int index = 0;
    for (int a = lo; a <= hi; a ++) {
      data[a] = ans[index];
      index ++;
    }
    System.out.println (data);
  }
  */

  /*
  private static int[] mergesort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      int[] ans = {data[lo]};
      return ans;
      //return merge (mergesort (data, lo, mid + 1), mergesort (data, mid + 1, hi + 1));
    }
    int mid = (lo +hi ) / 2; //dividing in half
    //return mergesort  (data, lo, mid +1);
    //mergesort (data, mid + 1, hi + 1);
    return merge (mergesort (data, lo, mid), mergesort (data,mid + 1, hi));
  }
  */

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




  /*
  private static void mergesort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      return ;
    }
    int mid = (lo + hi) / 2;
    mergesort (data, lo, mid);
    mergesort (data, mid + 1, hi);
    merge (data, lo, mid, hi);
  }

  private static void merge (int[] data, int lo, int middle, int hi) {
    int i = lo;
    int left = lo;
    int right = middle + 1;
    while (i < hi) {
      if (left >= middle) {
        for (int x = right; x < hi ; x ++) {
          data [i] = data[x];
          i ++;
        }
      }

      if (left >= hi) {
        for (int x = left; x < middle; x ++) {
          data[i] = data[x];
          i ++;
        }
      }

      if (data[left] <= data[left]) {
        data[i] = data[left];
        i ++;
        left ++;
      }
      else {
        data[i] = data[left];
        i ++;
        left ++;
      }

    }
  }
  */


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
    int[] a = {99,82,3,4,22,20,11,1};
    int[] b = {1,2,3,4};
    int[] c = {12,9,11,5,8,3};
    int[] d = {2,7,9,18};
    int[] e = {1,2,3,4,5,6};
    int[] f = {7,8,9,10,11};

    /*
    System.out.println (toString (merge (a, b)));
    System.out.println (toString (merge (c, d)));
    System.out.println (toString (merge (e, f)));
    */

    merge (test, 0, (test.length - 1)/2, test.length - 1);

    /*
    System.out.println (toString (mergesort (test, 0, test.length - 1)));
    System.out.println (toString (mergesort (a, 0, a.length - 1)));
    System.out.println (toString (mergesort (b, 0, b.length - 1)));
    System.out.println (toString (mergesort (c, 0, c.length - 1)));
    */


  }
}
