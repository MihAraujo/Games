package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesDao {
    // Tudo que está dentro do método companion é estático
    companion object {
        fun getGames(context: Context): List<Game> {

            val game1 = Game()
            game1.codigo = 1
            game1.nomeEnterprise = "Capcom"
            game1.nomeGame = "Street Fighter"
            game1.descricao = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta."
            game1.imagem = context.getDrawable(R.drawable.image_game)

            val game2 = Game()
            game2.codigo = 2
            game2.nomeEnterprise = "Konami"
            game2.nomeGame = "Ninja Turtles II"
            game2.descricao = "Teenage Mutant Ninja Turtles: Shredder's Revenge é um jogo eletrônico beat 'em up desenvolvido pela Tribute Games."
            game2.imagem = context.getDrawable(R.drawable.image_game_second)

            val game3 = Game()
            game3.codigo = 3
            game3.nomeEnterprise = "Capcom"
            game3.nomeGame = "Street Fighter"
            game3.descricao = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta."
            game3.imagem = context.getDrawable(R.drawable.image_game)

            val game4 = Game()
            game4.codigo = 4
            game4.nomeEnterprise = "Konami"
            game4.nomeGame = "Ninja Turtles II"
            game4.descricao = "Teenage Mutant Ninja Turtles: Shredder's Revenge é um jogo eletrônico beat 'em up desenvolvido pela Tribute Games."
            game4.imagem = context.getDrawable(R.drawable.image_game_second)

            val game5 = Game()
            game5.codigo = 5
            game5.nomeEnterprise = "Capcom"
            game5.nomeGame = "Street Fighter"
            game5.descricao = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta."
            game5.imagem = context.getDrawable(R.drawable.image_game)

            val listGames = listOf<Game>(game1, game2, game3, game4, game5)


            return listGames
        }
    }
}