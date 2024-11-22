package com.example.pam6_createproject.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam6_createproject.R

@Composable
fun MahasiswaFormView(
    onSubmitButtonClicked: (List<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul dan Islami",
                    color = Color.Red,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Masukkan Data Kamu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = "Isi sesuai data yang kamu daftarkan",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Input NIM
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nim,
                    onValueChange = { nim = it },
                    label = { Text(text = "NIM Mahasiswa") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "NIM"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Tambahan input nama dan email jika dibutuhkan
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(text = "Nama Mahasiswa") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Nama"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email Mahasiswa") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Email"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Submit
                Button(
                    onClick = { onSubmitButtonClicked(listOf(nim, nama, email)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(text = "Submit")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Tombol Kembali
                TextButton(
                    onClick = { onBackButtonClicked() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Kembali", color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMahasiswaFormView() {
    MahasiswaFormView(
        onSubmitButtonClicked = { },
        onBackButtonClicked = { }
    )
}
