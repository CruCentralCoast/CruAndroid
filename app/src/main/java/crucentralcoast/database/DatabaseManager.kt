package crucentralcoast.database

import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.ImageView
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import android.widget.TextView
import java.net.URI


data class DatabaseManager(val collectionName: String,
                           val db: FirebaseFirestore = FirebaseFirestore.getInstance())
{

    private val testDoc: String = "563b07402930ae0300fbc09b"

    fun setText(textView: TextView) {
        db.collection(collectionName).document(testDoc).get()
            .addOnSuccessListener {
                val tempStr = it.get("description")
                if(tempStr is String)
                    textView.text = tempStr
                else println("Value from Firestore is not of type String")
            }
    }



}