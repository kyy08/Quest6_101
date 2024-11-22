package com.example.pam6_createproject.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam6_createproject.Data.Matakuliah
import com.example.pam6_createproject.R
import com.example.pam6_createproject.ui.Model.Mahasiswa
import com.example.pam6_createproject.ui.view.screen.part.NavUniv
import com.example.pam6_createproject.ui.widget.DynamicSelectedTextField

@Composable
fun MatakuliahView(
    uiState: Mahasiswa,
    onSimpanButtonClicked: (List<String>) -> Unit,
    onBackButtonClicked: () -> Unit // Adding the onBackButtonClicked parameter
) {
    var chosenDropdown by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    val listKelas = listOf("A", "B", "C") // Kelas options

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavUniv() // University navigation component

        // Content area for displaying form and user information
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
                .padding(16.dp)
        ) {
            // Display Mahasiswa Information
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "NIM:", fontWeight = FontWeight.Bold)
                    Text(text = uiState.nim)
                    Text(text = "Nama:", fontWeight = FontWeight.Bold)
                    Text(text = uiState.nama)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Choose Matakuliah
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Pilih Matakuliah Peminatan", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silakan Pilih Matakuliah Yang Di inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // Dynamic dropdown to select matakuliah (course)
                DynamicSelectedTextField(
                    selectedValue = chosenDropdown,
                    options = Matakuliah.option,
                    label = "Matakuliah",
                    onValueChangeEvent = { chosenDropdown = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Choose Kelas (Class)
            Text(
                text = "Pilih Kelas:",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Column {
                listKelas.forEach { kelasItem ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = kelas == kelasItem,
                            onClick = { kelas = kelasItem }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = kelasItem)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Save Button
            Button(
                onClick = { onSimpanButtonClicked(listOf(chosenDropdown, kelas)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Simpan")
            }

            // Back Button
            Button(
                onClick = { onBackButtonClicked() }, // Call the back navigation function
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Back")
            }
        }
    }




