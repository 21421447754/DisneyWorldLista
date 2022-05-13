package martinez.miguel.disneyworldlista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class disneyAdapter (val images:List<String>):RecyclerView.Adapter<DisneyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return DisneyViewHolder(layoutInflater.inflate(R.layout.item_disney,parent,false))
    }

    override fun onBindViewHolder(holder: DisneyViewHolder, position: Int) {
    val item = images[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int {
        return images.size
    }
}