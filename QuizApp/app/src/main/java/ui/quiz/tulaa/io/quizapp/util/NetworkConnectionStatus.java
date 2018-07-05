package ui.quiz.tulaa.io.quizapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import ui.quiz.tulaa.io.quizapp.R;


public class NetworkConnectionStatus {


	/**
	 * Check for internet connectivity.
	 *
	 * @param context
	 * @return
	 */
    public static boolean isConnnected(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {

            return false;
        }
        return true;
    }




}
