package ba.unsa.etf.rma.movieapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ConnectivityBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork
        val capabilities = cm.getNetworkCapabilities(network)
        if (capabilities == null) {
            val toast = Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(context, "Connected", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}