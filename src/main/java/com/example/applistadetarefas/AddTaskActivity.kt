package com.example.applistadetarefas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val editTextTitulo =
            findViewById<EditText>(R.id.editTextTitulo)

        val editTextDescricao =
            findViewById<EditText>(R.id.editTextDescricao)

        val spinnerPrioridade =
            findViewById<Spinner>(R.id.spinnerPrioridade)

        val buttonSalvar =
            findViewById<Button>(R.id.buttonSalvar)

        // Opções de prioridade
        val prioridades = arrayOf(
            "Alta",
            "Média",
            "Baixa"
        )

        val adapterPrioridade = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            prioridades
        )

        adapterPrioridade.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerPrioridade.adapter = adapterPrioridade

        val modoEdicao =
            intent.getBooleanExtra("modoEdicao", false)

        val posicao =
            intent.getIntExtra("posicao", -1)

        // Se estiver editando uma tarefa
        if (modoEdicao) {

            editTextTitulo.setText(
                intent.getStringExtra("titulo") ?: ""
            )

            editTextDescricao.setText(
                intent.getStringExtra("descricao") ?: ""
            )

            val prioridadeSalva =
                intent.getStringExtra("prioridade") ?: "Média"

            val indicePrioridade =
                prioridades.indexOf(prioridadeSalva)

            if (indicePrioridade >= 0) {
                spinnerPrioridade.setSelection(
                    indicePrioridade
                )
            }

            buttonSalvar.text = "Salvar Alterações"
        }

        // Salvar tarefa
        buttonSalvar.setOnClickListener {

            val titulo =
                editTextTitulo.text.toString()

            val descricao =
                editTextDescricao.text.toString()

            val prioridade =
                spinnerPrioridade.selectedItem.toString()

            if (titulo.isNotEmpty()) {

                val resultado = intent

                resultado.putExtra(
                    "titulo",
                    titulo
                )

                resultado.putExtra(
                    "descricao",
                    descricao
                )

                resultado.putExtra(
                    "prioridade",
                    prioridade
                )

                resultado.putExtra(
                    "posicao",
                    posicao
                )

                setResult(
                    RESULT_OK,
                    resultado
                )

                finish()
            }
        }
    }
}