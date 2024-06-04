package lcmc23.com.lucascabral_rm94954_recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import lcmc23.com.lucascabral_rm94954_recyclerview.adapter.ItemsAdapter
import lcmc23.com.lucascabral_rm94954_recyclerview.model.ItemModel
import lcmc23.com.lucascabral_rm94954_recyclerview.ui.theme.LucasCabral_RM94954_RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextPraia = findViewById<EditText>(R.id.editTextPraia)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)

        button.setOnClickListener {
            val praia = editTextPraia.text.toString()
            val cidade = editTextCidade.text.toString()
            val estado = editTextEstado.text.toString()

            if (praia.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                editTextPraia.error = "Preencha todos os campos"
                return@setOnClickListener
            }

            val item = ItemModel(
                name = praia,
                city = cidade,
                state = estado,
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)


            editTextPraia.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }
    }
}
