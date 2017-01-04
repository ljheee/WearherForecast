package util;

import android.content.Context;
import android.widget.Toast;


public class ToastUtl {
    public static void ShowToast(String str, Context context) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
