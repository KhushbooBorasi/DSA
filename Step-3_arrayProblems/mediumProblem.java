import java.util.*;

class pair{
    long first , second;
    public pair(long first , long second){
        this .first = first;
        this.second = second;
    }
}
public class mediumProblem{
  
  // supporting function
  public static void swap(int[] arr , int i , int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

    // Que.1 2sum problem
    public static ArrayList<pair> allPairWihGivenSum(int[] arr1 , int[] arr2 , int x){
      ArrayList<pair> ans = new ArrayList<>();
    //    int count = 0;
       Set<Integer> set = new HashSet<>();
       for(int i=0; i<arr2.length; i++){
        set.add(arr2[i]);
       }
       for(int i=0; i<arr1.length; i++){
        if(set.contains(x-arr1[i])){
            pair p= new pair(arr1[i], x-arr1[i]);
           
            ans.add(p);
            
        }
       }

        return ans;
    }
   
    // Que.2 sort an array of 0,1 and 2
    public static void sortAnArray(int[] arr , int n){
        int l = 0, m =0 , h = n-1;
        while(m<=h){
          if(arr[m]==0 ){
            int temp = arr[m];
            arr[m] = arr[l];
            arr[l] = temp;
            m++;
            l++;
          }
          else if(arr[m]==1){
            if(arr[m]==1){
              m++;
            }
          }
          else if(arr[m]==2){
            int temp = arr[m];
            arr[m] = arr[h];
            arr[h] = temp;
            h--;
          }
        }

    }
   
    // Que.3 Majority element
    public static int majorityElement(int[] a , int size){
      int ans = -1, b = size/2;
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int elem:a){
        if(map.containsKey(elem)){
          map.put(elem , map.get(elem)+1);
          int an = map.get(elem);
         
          if(an>b){
          
           ans =  elem;
        
           break;
          }
        }
        else{
          map.put(elem, 1);
        }

      
      }
  
      return ans;
    }
   
    // Que.4 Kaden's algorithm
    public static long maxSubarraySum(int[] arr , int n){
      long ans = arr[0] , sum = arr[0];
      for(int i=1; i<n; i++){
        sum+=arr[i];
        sum = Math.max(sum , arr[i]);
        
        if(sum > ans){
          ans = sum;
        }
        if(sum < 0){
          sum = 0;
        }
      }
      return ans;
    }
    
    // Que.5 Max sum in sub arrays

    // Que.6 stock buy and sell

    // Que. 7 alternative positive and negative number
    public static void rearrange(int[] arr){
      int n = arr.length,b = 0 ,i = 1 , j = 2;
      boolean positive = true;
      if(arr[b]<0){
        while(i<n){
          if(arr[b]<0 && arr[i]>=0){
            swap(arr , b , i);
          }
          else{
            while(i<n && arr[i]<0){
              i++;
            }
          }
        }
        b++;
        i = b+1;
        j = i+1;
      }
      
      while(j<n){
           if(positive){
              if(arr[i]>=0){
                 if(arr[j]<0){
                     swap(arr , i ,j);
                     b = i;
                     i++;
                     j = i+1;
                     positive = false;
                 }
                 else{
                  while(j<n && arr[j]>=0){
                    j++;
                  }
                 }
              }
              else{
                b = i;
                i++;
                j++;
                positive = false;
              }
              
           }
           else{
              if(arr[i]<0){
                if(arr[j]>=0){
                  swap(arr, i, j);
                  b = i;
                  i++;
                  j= i+1;
                  positive = false;
                }
                else{
                  while(j<n && arr[j]<0){
                    j++;
                  }
                }
              }
              else{
                b = i;
                i++;
                j++;
                positive = true;
              }
           } 
      }

    }
    
    // Que.8 next permutation

    // Que. 9 leaders in an array
    public static ArrayList<Integer> leaders(int[] arr, int n){
      ArrayList ans = new ArrayList<>();
      int i = n-1 , j = n-2 , max = arr[i];
      ans.add(arr[i]);
      while(j>0){
        if(arr[j]>max){
          max = arr[j];
          ans.add(max);
          i--;
          j--;
        }
        else{
          i--;
          j--;
        }
      }
      Collections.reverse(ans);
      return ans;
    } 
    
    // Que.10 longest Consecutive subsequences
    public static int findLongestConseqSubseq(int[] arr){
      int max = 1 , count = 1;
      HashSet<Integer> set = new HashSet<>();
      for(int elem:arr){
        set.add(elem);
      }
      for(int elem:arr){
          if(!set.contains(elem-1)){
            int a = elem+1;
             while(set.contains(a)){
              a++;
              count++;

             }  
             if(count > max){
              max = count;
              count = 1;
             } 
          }
      }
      return max;
    }
    
    // Que.11 make zeroes
    public static void makeZeroes(int[][] arr , int n , int m){
 
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
             if(arr[i][j]==0){
         
              int sum = arr[i-1][j]+arr[i][j+1]+arr[i+1][j]+arr[i][j-1];
              arr[i][j] = sum;
              arr[i-1][j] = 0;
              arr[i][j+1] = 0;
              arr[i+1][j] = 0;
              arr[i][j-1] = 0;
             
              return; 

             }
        }
      }
    }

    // Que.12 rotate by 90degree --> submitted on gfg but do hear also

    // Que.13 Spiral martix
    public static int findk(int[][] arr , int n , int m , int p){
      int row = n , col = m , sr  =0 , sc = 0;
      int i=0 , j=0 , k = 0;
      int[] ans  = new int[(n*m)-1];
      
      while(i>=sr && j>=sc && i<row && j<col){

        while(j<col && k <ans.length ){
         ans[k] = arr[i][j];
       
       
         j++;
         k++;
        }
        j--;
        i++;
        sr++;

        while(i<row && k < ans.length ){
        
          ans[k] = arr[i][j];
          i++;
          k++;
        }
        i--;
        j--;
        col--;

        
        while(j>=sc && k < ans.length ){
          
          ans[k] = arr[i][j];
          j--;
          k++;
        }
       
        j++;
        i--;
        row--;
        

     
      
        while(i>=sr && k < ans.length ){
         
          ans[k] = arr[i][j];
          i--;
          k++;
        }
   
        i++;
        j++;
        
        sc++;
        
        

      }
     
      for(int elem:ans){
        System.out.print(elem+" ");
      }
      return ans[p-1];
    }
    public static void main(String[] args){
      // Que. 1
    //   int[] arr1 = {-1,-2,4,-6,5,7};
    //   int[] arr2 = {6,3,4,0};
     
    //    ArrayList<pair> list = allPairWihGivenSum(arr1,arr2,8);
    //   for(pair p: list){
    //     System.out.print(p.first+" ");
    //     System.out.print(p.second+" ");
    //     System.out.println();

    // Que.2
    // int[] arr = {0,2,1,2,0};
    //  sortAnArray(arr, arr.length);
    //  for(int elem:arr){
    //    System.out.println(elem);
    //  }
    
    // Que.3
    // int[] arr = {21,2,3,3,3};
    // System.out.println(majorityElement(arr, arr.length));

    // Que.4 
    // int[] arr = {1,2,3,-2,5};
    // int[] arr2 = {-1,-2,-3,-1};
    // System.out.println(maxSubarraySum(arr, arr.length));
    // System.out.println(maxSubarraySum(arr2, arr2.length));

    // Que.7 
    // int[] arr = {-9,4,-2,-1,5,0,-5,-3,2};
    // rearrange(arr);
    // for(int elem: arr){
    //   System.out.println(elem);
    // }

    // Que.8 

    // Que.9 
    // leaders in an array
    // int[] arr = {1,2,3,4,0};
    // ArrayList<Integer> ans = leaders(arr, arr.length);
    
    // for(int elem:ans){
    //   System.out.print(elem+" ");
    // } 

    // Que. 10 longest common subsequence
    // int[] arr = {1,9,3,10,4,20,2};
    // System.out.println(findLongestConseqSubseq(arr));

    // Que. 11 make zeroes
    // int[][] arr = {
    //  {1,2},
    //  {3,4}
    // };
    // makeZeroes(arr, arr[0].length, arr.length);
    // for(int i=0; i<arr[0].length; i++){
    //   for(int j=0; j<arr.length; j++){
    //     System.out.print(arr[i][j]+" ");
    //   }
    //   System.out.println();
        
    // }

    // Que.13
       int[][] arr = {
     {1,2,3},
     {4,5,6},
     {7,8,9}
             };
     System.out.println(findk(arr, arr[0].length, arr.length, 4));


    }
        
    }
