import java.util.*; 
public class easyProblems {

    // supporting functions starts here
    public static int sum(int N){
        if(N==1){
            return 1;
        }
        return N+sum(N-1);

    }
    
    public static int[] reverse(int[] arr , int s , int e){
         
         while(e>s){
             int temp = arr[s];
             arr[s] = arr[e];
             arr[e] = temp;
             s++;
             e--;
         }
        
         return arr;
    }
  
    public static long[] reverse1(long[] arr , int s , int e){
         
        while(e>s){
            long temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
       
        return arr;
   }
    // supporting functions ends here


    public static int largestElement(int[] arr){
        int ans = arr[0];
        for(int i=1; i<arr.length; i++){
             if(ans < arr[i]){
                 ans = arr[i];
             }
        }
        return ans;
    }
    
    // Que.2 easy
    public static int secondLargestElemetOfArray(int[] arr , int n){
        if(n==1){
            return -1;
        }
        int l = 0 , sm = 0 , i = 2;
        if(arr[0]>=arr[1]){
            l = arr[0];
            sm = arr[1];
        }
        else{
            sm = arr[0];
            l = arr[1];
        }
        while(i<n && l==sm){
            if(arr[i]>l){
                l = arr[i];   
            }
            else if(arr[i]<sm){
                sm = arr[i];
            }
            i++;
        }
        if(l==sm || i==n ) return -1;

        for(int j=i; j<n; j++){
            if(arr[j]>l){
                sm = l;
                l = arr[j];
            }
            else if(arr[j]>sm && arr[j]<l){
               sm = arr[j];
            }

        }

       return sm;
    }
    
    public static boolean checkSortedOrNot(int[] arr){
        int i=0,j=1;
        while(j<arr.length){
            if(arr[j]<arr[i]){
            
                return false;
            }
            j++;
            i++;
        } 
        return true;
    } 

    // que.4 easy
    public static int removeDuplicateFromSortedArray(int[] arr , int n){
      if(n==1) return 1;
      int i = 0 , j = 1;
      while(j<n && arr[i]!=arr[j]){
        j++;
        i++;
      }
      if(j==n) return n;

      while(j<n){
        if(arr[i]==arr[j]){
            j++;
            
        }
        else{
            i++;
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp; 
           j++;
        
        }
      }
      
      return i+1;

    }
    
    // Que.5 easy
    public static void quickLeftRotation(long[] arr , int K){
        if(K<0){
            K = K+arr.length;
        }
        if(K>arr.length){
            K = K%2;
        }
        if(K==arr.length){
            for(long elem:arr){
                System.out.print(elem+" ");
            }
            System.out.println();
            return;
        }
        reverse1(arr, 0, K-1);
        reverse1(arr, K, arr.length-1);
        reverse1(arr, 0, arr.length-1);

        for(long elem:arr){
            System.out.print(elem+" ");
        }
        System.out.println();
    }
    
    public static void rotationOfArray(int[] arr){

    }

    // Que.6 easy
    public static void moveZeroesToEnd(int[] arr , int n){
        int l = 0 , h = n-1;
        while(l<h){
            if(arr[h] ==0){
                h--;
            }
             if(arr[l]!=0){
                l++;
            }
           if(arr[l]==0){
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
                l++;
            } 
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
     
    }
    // Que.7
    public static int linearSearch(int[] arr , int k){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==k){
                return 1;
            }
        }
        return -1;
    }
    // Que.8 easy
    public static ArrayList<Integer> unionOfTwoArrays(int[] a1 , int[] b1 , int n , int m){
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0  ,j=0;
        while(i<n && j<m){
            if(a1[i]<b1[j]){
                ans.add(a1[i]);
                i++;
            }
            else if(a1[i]>b1[j]){
                ans.add(b1[j]);
                j++;
            }
            else{
               ans.add(a1[i]);
               i++;
               j++;
            }
        }
        while(i<n){
            ans.add(a1[i]);
                i++;
        }
        while(j<m){
            ans.add(b1[j]);
            j++;
        }
        return ans;
    }
    
    public static void intersectionOFTwoArrays(int[] arr1 , int[] arr2){
        int i=0 , j=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                System.out.print(arr1[i]+" ");
              
                    i++;
                    j++;
                
               
            }
        }
    }
    
    public static int missingNumber(int[] arr , int N){
        int a = sum(N);
        for(int elem:arr){
            a-=elem;
        }
        return a;
    }
  
    // Que.12 maximum 1's
    public static int rowWithMax1s(int[][] arr , int n , int m){
        int  i=0,j=0;
        while(j<m){
            i=0;
            while(i<n){
                if(arr[i][j]==1){
                    return i;
                }
                else{
                    i++;
                }
            }
            j++;
        }
        return -1;
    }
    public static void main(String[] args){
    // long[] arr = {-36,-28,83,59,-5,-22,15,64,78,89,90,68};
    // quickLeftRotation(arr, 276);

    // int[] arr = {3,5,0,0,4};
    // int[] arr2 = {0,0,35,0,1};
    // int[] arr3 = {0,0,35,0};
    // int[] arr4 = {0,0,35};

    // moveZeroesToEnd(arr, arr.length);
    // moveZeroesToEnd(arr2, arr2.length);
    // moveZeroesToEnd(arr3, arr3.length);
    // moveZeroesToEnd(arr4, arr4.length);
    int[] arr = {5,13,45,3,2,1};
    int[] arr2 = {7,4,17,0,12};

    System.out.println( unionOfTwoArrays( arr,arr2,arr.length,arr2.length));

    // unionOfTwoArrays(arr, arr2);

}
}

