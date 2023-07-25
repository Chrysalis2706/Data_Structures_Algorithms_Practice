public class DevideAndConquer_InversionCount {

    public static int merge_count(int[] arr, int si, int ei){
        int inv = 0;
        if (si>=ei) return 0;
        int mid = si + (ei-si)/2;
        inv += merge_count(arr, si, mid);
        inv += merge_count(arr, mid+1, ei);

        inv += merge(arr, si, mid, ei);

        return inv;
    }

    public static int merge(int[] arr, int si, int mid, int ei){
        int inv = 0;
        int i = si;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[ei-si+1];

        while (i<=mid && j<=ei){
            if (arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
                inv = inv + (mid+1-i);
            }
            k++;
        }

        while (i<=mid) temp[k++] = arr[i++];
        while (j<=ei) temp[k++] = arr[j++];

        for (k=0, i=si; k< temp.length; k++, i++){
            arr[i] = temp[k];
        }

        return inv;
    }

    public static void main(String[] args){
        int[] arr = {2, 4, 1, 3, 5};
        int ans = merge_count(arr, 0, arr.length-1);
        System.out.println(ans);
    }

}
