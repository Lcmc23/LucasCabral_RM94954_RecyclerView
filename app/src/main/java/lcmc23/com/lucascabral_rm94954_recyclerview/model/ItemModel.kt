package lcmc23.com.lucascabral_rm94954_recyclerview.model

data class ItemModel(
    val name: String,
    val city: String,
    val state: String,
    val onRemove: (ItemModel) -> Unit
)

