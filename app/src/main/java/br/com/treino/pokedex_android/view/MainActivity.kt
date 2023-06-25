package br.com.treino.pokedex_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Chronometer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.treino.pokedex_android.R
import br.com.treino.pokedex_android.api.PokemonRepository
import br.com.treino.pokedex_android.api.model.PokemonApiResult
import br.com.treino.pokedex_android.api.model.PokemonsApiResult
import br.com.treino.pokedex_android.domain.Pokemon
import br.com.treino.pokedex_android.domain.PokemonType
import br.com.treino.pokedex_android.viewmodel.PokemonViewModel
import br.com.treino.pokedex_android.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView



    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
                .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvPokemons)



        viewModel.pokemons.observe(this, Observer{
            loadRecyclerView(it)
        })




    }





    private fun loadRecyclerView(pokemons: List<Pokemon?>)  {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonAdapter(pokemons)

    }
}





