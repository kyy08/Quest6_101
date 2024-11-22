package com.example.pam6_createproject.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pam6_createproject.R
import com.example.pam6_createproject.ui.Model.Mahasiswa
import com.example.pam6_createproject.ui.view.screen.part.NavUniv

@Composable
fun TampilView(
    uiState: Mahasiswa,
    onBackButtonClicked: () -> Unit = {},
    onResetButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Konten Utama
        NavUniv()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Informasi Mahasiswa
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("NIM:")
                Text(uiState.nim)
                Spacer(modifier = Modifier.height(8.dp)) // Spasi antar item
                Text("Nama:")
                Text(uiState.nama)
                Spacer(modifier = Modifier.height(8.dp)) // Spasi antar item
                Text("Email:")
                Text(uiState.email)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Informasi Mata Kuliah
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mata Kuliah yang diambil:")
                Text(uiState.namaMatakuliah)
                Text("Kelas:")
                Text(uiState.kelas)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Tombol Aksi
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onBackButtonClicked) {
                    Text(text = "Kembali")
                }
                Button(onClick = onResetButtonClicked) {
                    Text(text = "Reset")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTampilView() {
    val dummyMahasiswa = Mahasiswa(
        nim = "123456",
        nama = "John Doe",
        email = "john.doe@example.com",
        namaMatakuliah = "Pemrograman Mobile",
        kelas = "A"
    )
    TampilView(
        uiState = dummyMahasiswa,
        onBackButtonClicked = { /* TODO */ },
        onResetButtonClicked = { /* TODO */ }
    )


