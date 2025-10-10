package com.example.bai_tap_tuan_2
import android.R
import android.net.wifi.ScanResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bai_tap_tuan_2.ui.theme.Bai_tap_tuan_2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai_tap_tuan_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ListNumbers(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    InformationUser(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    CheckEmail(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ListNumbers(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var number by remember { mutableStateOf(0) }
    Column( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            OutlinedTextField(
                shape = RoundedCornerShape(20.dp),
                value = text,
                onValueChange = { text = it },
                label = { Text("Nhập")}
            )
            Button(onClick = {
                val parsedNumber = text.toIntOrNull()
                if (parsedNumber == null || parsedNumber <= 0) {
                    errorMessage = "Dữ liệu bạn nhập không hợp lệ"
                    number = 0
                } else {
                    errorMessage = ""
                    number = parsedNumber
                }
            },
                modifier = Modifier.padding(start = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(
                        red = 3,
                        green = 169,
                        blue = 244,
                        alpha = 255),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp)
            )
            {
                Text("Tạo");
            }
        }

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
                ListNb(number)


    }

}
@Composable
fun ListNb(n: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    ) {
        for (i in 1..n) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(bottom = 8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Red)
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$i", color = Color.White)
            }
        }
    }
}
@Composable
fun InformationUser(modifier: Modifier = Modifier){
    var fullname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var messageError by remember { mutableStateOf("") }
    var isShow by remember { mutableStateOf(false) }
    var ten by remember { mutableStateOf("") }
    var tuoi by remember { mutableStateOf("") }
    var mota by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color(red = 206, green = 206, blue = 206, alpha = 255),
                shape = RoundedCornerShape(15.dp))
            .padding(10.dp),){
            Column (modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)){
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text="Họ và tên",fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White),
                        value = fullname,
                        onValueChange = { fullname = it },
                        modifier= Modifier.width(200.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text="Tuổi", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        ),
                        value = age,
                        onValueChange = { age = it },
                        modifier = Modifier.width(200.dp)
                    )
                }
            }

        }
        Button(onClick = {
            var checkNumber = age.toIntOrNull();
            messageError=""
            if(fullname.isEmpty()){
                messageError = "Vui lòng nhập tên"
                isShow = false
            }
            else if(checkNumber == null|| checkNumber <1)
            {
                messageError += "Vui lòng nhập tuổi hợp lệ"
                age=""
                isShow = false
            }
            else{
                when{
                    checkNumber < 2 -> mota = "em bé"
                    checkNumber  <= 6 -> mota="trẻ em"
                    checkNumber  <= 65 -> mota="người lớn"
                    checkNumber  > 65 -> mota="người già"
                }

                messageError=""
                ten = fullname
                tuoi = age
                isShow = true
            }


        },
            modifier = Modifier.padding(15.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
            containerColor = Color(red = 3, green = 169, blue = 244, alpha = 255)
        )
        ) {
            Text(text="Kiểm tra", fontWeight = FontWeight.Bold,  fontSize = 15.sp, color = Color.White)
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if(isShow)
            {
                Text(text="Tên: $ten")
                Text(text="Tuổi: $tuoi")
                Text(text="Mô tả: $mota ")
            }
            if (messageError.isNotEmpty()) {
                Text(text = messageError, color = Color.Red)
            }



        }
    }

}
@Composable
fun CheckEmail(modifier: Modifier = Modifier)
{
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center

) {
    OutlinedTextField(
        value = email,
        onValueChange = {email = it},
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),


    )
    Text(text = "$message")
    Button(onClick = {

    if(isEmail(email)){
        message=" ${email} hợp lệ"
    }
    else{
            message=" Email không đúng định dạng"
    }
    },
        modifier= Modifier.padding(5.dp,10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(red = 3, green = 169, blue = 244, alpha = 254)
        )) {
        Text(text = "Kiểm tra")
    }

}
}
fun isEmail(email:String): Boolean{
    val emailRegex ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex();
    return  email.matches(emailRegex);
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bai_tap_tuan_2Theme {
        ListNumbers()
    }
}