package martinez.miguel.disneyworldlista

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import martinez.miguel.disneyworldlista.databinding.ItemDisneyBinding

class DisneyViewHolder(view: View):RecyclerView.ViewHolder(view) {

  private val binding = ItemDisneyBinding.bind(view)

    fun bind(image:String){
Picasso.get().load(image).into(binding.ivDisney)
    }
}

