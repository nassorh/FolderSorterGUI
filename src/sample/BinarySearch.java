package sample;

import java.util.List;

class BinarySearch {
    public static int binarySearch(List arr, String extension, int first, int last){
        //Postcondition returns the index of the position of the extension in the database array
        if (first>last){
            return -1;
        }else{
            int mid = (first + last) / 2;
            String databaseExt = ((String) arr.get(mid)).split(":")[0]; //Fetches the extension alone
            int compare = extension.compareTo(databaseExt);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                return binarySearch(arr, extension, first, mid - 1);
            } else if (compare > 0) {
                return binarySearch(arr, extension, mid + 1, last);
            }
        }
        return -1;
    }
}
