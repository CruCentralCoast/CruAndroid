package crucentralcoast.android

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import crucentralcoast.database.DatabaseManager

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView

    var db = DatabaseManager("movements")
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_events -> {
                textMessage.setText("Events")
                db.setText(textMessage)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_community -> {
                textMessage.setText("Community")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ministry -> {
                textMessage.setText("Ministry")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_missions -> {
                textMessage.setText("Missions")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_resources -> {
                textMessage.setText("Resources")
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
