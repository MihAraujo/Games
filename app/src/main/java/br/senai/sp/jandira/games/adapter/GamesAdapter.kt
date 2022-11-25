package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGame>() {

    private var gameList = listOf<Game>()

    fun updateGameList(games: List<Game>) {
        this.gameList = games
        notifyDataSetChanged()
    }

    class HolderGame(view: View): RecyclerView.ViewHolder(view) {
        val textGameTitle = view.findViewById<TextView>(R.id.editTextNameGame)
        val textEnterprise = view.findViewById<TextView>(R.id.editTextNameEnterprise)
        val textDescricao = view.findViewById<TextView>(R.id.editTextDescricao)
        val imageHolder = view.findViewById<ImageView>(R.id.imageHolder)

        fun bind(game: Game) {
            textGameTitle.text = game.nomeGame
            textEnterprise.text = game.nomeEnterprise
            textDescricao.text = game.descricao
//            imageHolder.setImageDrawable(game.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGame {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horder_layout, parent, false) // O false é no caso de querer ou não mudar o layout
        return HolderGame(view)
    }

    override fun onBindViewHolder(holder: HolderGame, position: Int) {
        holder.bind(gameList[position])
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

}