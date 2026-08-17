package com.example.applistadetarefas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class Tarefa(
    val titulo: String,
    val descricao: String,
    var concluida: Boolean = false,
    var prioridade: String = "Média"
)

class MainActivity : AppCompatActivity() {

    private val tarefas = ArrayList<Tarefa>()
    private lateinit var adapter: TarefaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val listaTarefas =
            findViewById<ListView>(R.id.listaTarefas)

        val btnAdicionar =
            findViewById<Button>(R.id.btnAdicionar)

        val preferencias =
            getSharedPreferences(
                "tarefas",
                MODE_PRIVATE
            )

        val tarefasSalvas =
            preferencias.getStringSet(
                "lista",
                emptySet()
            ) ?: emptySet()

        for (tarefaSalva in tarefasSalvas) {

            val partes =
                tarefaSalva.split(
                    "|||",
                    limit = 4
                )

            val titulo =
                partes[0]

            val descricao =
                if (partes.size > 1) {
                    partes[1]
                } else {
                    ""
                }

            val concluida =
                if (partes.size > 2) {
                    partes[2].toBoolean()
                } else {
                    false
                }

            val prioridade =
                if (partes.size > 3) {
                    partes[3]
                } else {
                    "Média"
                }

            tarefas.add(
                Tarefa(
                    titulo = titulo,
                    descricao = descricao,
                    concluida = concluida,
                    prioridade = prioridade
                )
            )
        }

        ordenarTarefas()

        adapter =
            TarefaAdapter(
                this,
                tarefas
            )

        listaTarefas.adapter =
            adapter

        btnAdicionar.setOnClickListener {

            val intent =
                Intent(
                    this,
                    AddTaskActivity::class.java
                )

            startActivityForResult(
                intent,
                1
            )
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {

        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        // NOVA TAREFA
        if (
            requestCode == 1 &&
            resultCode == RESULT_OK
        ) {

            val titulo =
                data?.getStringExtra("titulo")

            val descricao =
                data?.getStringExtra("descricao")

            val prioridade =
                data?.getStringExtra("prioridade")
                    ?: "Média"

            if (!titulo.isNullOrEmpty()) {

                tarefas.add(
                    Tarefa(
                        titulo = titulo,
                        descricao = descricao ?: "",
                        concluida = false,
                        prioridade = prioridade
                    )
                )

                ordenarTarefas()

                adapter.notifyDataSetChanged()

                salvarTarefas()
            }
        }

        // EDITAR TAREFA
        if (
            requestCode == 2 &&
            resultCode == RESULT_OK
        ) {

            val posicao =
                data?.getIntExtra(
                    "posicao",
                    -1
                ) ?: -1

            val titulo =
                data?.getStringExtra("titulo")

            val descricao =
                data?.getStringExtra("descricao")

            val prioridade =
                data?.getStringExtra("prioridade")
                    ?: "Média"

            if (
                posicao >= 0 &&
                posicao < tarefas.size &&
                !titulo.isNullOrEmpty()
            ) {

                tarefas[posicao] =
                    Tarefa(
                        titulo = titulo,
                        descricao = descricao ?: "",
                        concluida = tarefas[posicao].concluida,
                        prioridade = prioridade
                    )

                ordenarTarefas()

                adapter.notifyDataSetChanged()

                salvarTarefas()
            }
        }
    }

    private fun abrirEdicao(position: Int) {

        val tarefa =
            tarefas[position]

        val intent =
            Intent(
                this,
                AddTaskActivity::class.java
            )

        intent.putExtra(
            "modoEdicao",
            true
        )

        intent.putExtra(
            "posicao",
            position
        )

        intent.putExtra(
            "titulo",
            tarefa.titulo
        )

        intent.putExtra(
            "descricao",
            tarefa.descricao
        )

        intent.putExtra(
            "prioridade",
            tarefa.prioridade
        )

        startActivityForResult(
            intent,
            2
        )
    }

    private fun excluirTarefa(
        position: Int
    ) {

        tarefas.removeAt(position)

        adapter.notifyDataSetChanged()

        salvarTarefas()
    }

    private fun ordenarTarefas() {

        tarefas.sortBy {

            when (it.prioridade) {

                "Alta" -> 1

                "Média" -> 2

                "Baixa" -> 3

                else -> 2
            }
        }
    }

    private fun salvarTarefas() {

        val preferencias =
            getSharedPreferences(
                "tarefas",
                MODE_PRIVATE
            )

        val tarefasParaSalvar =
            tarefas.map {

                "${it.titulo}|||${it.descricao}|||${it.concluida}|||${it.prioridade}"

            }.toSet()

        preferencias.edit()
            .putStringSet(
                "lista",
                tarefasParaSalvar
            )
            .apply()
    }

    inner class TarefaAdapter(
        private val context: Context,
        private val tarefas: ArrayList<Tarefa>
    ) : ArrayAdapter<Tarefa>(
        context,
        0,
        tarefas
    ) {

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {

            val view =
                convertView
                    ?: LayoutInflater.from(context)
                        .inflate(
                            R.layout.item_tarefa,
                            parent,
                            false
                        )

            val textTitulo =
                view.findViewById<TextView>(
                    R.id.textTitulo
                )

            val textDescricao =
                view.findViewById<TextView>(
                    R.id.textDescricao
                )

            val checkConcluida =
                view.findViewById<CheckBox>(
                    R.id.checkConcluida
                )

            val buttonExcluir =
                view.findViewById<Button>(
                    R.id.buttonExcluir
                )

            val tarefa =
                tarefas[position]

            textTitulo.text =
                tarefa.titulo

            textDescricao.text =
                "${tarefa.descricao}\nPrioridade: ${tarefa.prioridade}"

            checkConcluida.setOnCheckedChangeListener(
                null
            )

            checkConcluida.isChecked =
                tarefa.concluida

            checkConcluida.setOnCheckedChangeListener {
                    _,
                    marcada ->

                tarefa.concluida =
                    marcada

                salvarTarefas()
            }

            view.setOnClickListener {

                abrirEdicao(position)
            }

            checkConcluida.setOnClickListener {

                tarefa.concluida =
                    checkConcluida.isChecked

                salvarTarefas()
            }

            buttonExcluir.setOnClickListener {

                excluirTarefa(position)
            }

            return view
        }
    }
}