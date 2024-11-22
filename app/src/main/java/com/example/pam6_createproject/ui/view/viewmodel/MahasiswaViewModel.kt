package com.example.pam6_createproject.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pam6_createproject.ui.Model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MahasiswaViewModel: ViewModel() {
    private val _statusUI = MutableStateFlow(Mahasiswa())
    val statusUI: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun setMahasiswa(ls: List<String>) {
        _statusUI.update {statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2],

            )
        }
    }
    fun setMatakuliah(ls: List<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                namaMatakuliah = ls[0],
                kelas = ls[1],
            )
        }
    }
}