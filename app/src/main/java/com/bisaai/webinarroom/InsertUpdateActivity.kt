package com.bisaai.webinarroom

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_insert_update.*

class InsertUpdateActivity : AppCompatActivity() {

    private var dataFlag: String? = ""
    private var dataUser: UserEntity? = null
    private lateinit var viewModel: DataViewModel

    companion object{
        const val DATAFLAG = "DATAFLAG"
        const val TAMBAHDATA = "TAMBAHDATA"
        const val EDITDATA = "EDITDATA"
        const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_update)

        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        dataFlag = intent.getStringExtra(DATAFLAG)
        if (dataFlag == EDITDATA){
            dataUser = intent.getParcelableExtra(DATA)
            etNisn.setText(dataUser?.nisn)
            etNama.setText(dataUser?.nama)
            etAlamat.setText(dataUser?.alamat)
            etKelas.setText(dataUser?.kelas)
            etNisn.isEnabled = false
        }

        btnSimpan.setOnClickListener {
            val user =  UserEntity(
                nisn = etNisn.text.toString(),
                nama = etNama.text.toString(),
                kelas = etKelas.text.toString(),
                alamat = etAlamat.text.toString()
            )
            when(dataFlag){
                TAMBAHDATA -> {
                    viewModel.insertData(user)
                    etNisn.setText("")
                    etNama.setText("")
                    etAlamat.setText("")
                    etKelas.setText("")
                    etKelas.clearFocus()
                    Toast.makeText(this, "Data berhasil di tambah", Toast.LENGTH_SHORT).show()
                    clTambahEdit.requestFocus()
                }
                EDITDATA -> {
                    viewModel.updateData(user)
                    Toast.makeText(this, "Data berhasil di update", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}