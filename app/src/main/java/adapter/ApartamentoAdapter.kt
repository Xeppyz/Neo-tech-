package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fora_neo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import datos.Apartamento
import datos.ListaApartamentos
import java.lang.Appendable

class ApartamentoAdapter(private val listaApartamento:List<Apartamento>):RecyclerView.Adapter<ApartamentoViewHolder>() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartamentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ApartamentoViewHolder(layoutInflater.inflate(R.layout.apartamento_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ApartamentoViewHolder, position: Int) {
        val item = listaApartamento[position]

        val likes = item.likes!!.toMutableList()
        val liked = likes.contains(auth.uid)
            holder.renderizar(item)
        holder.like(likes, liked, item)


    }

    override fun getItemCount(): Int {
        return listaApartamento.size
    }


}