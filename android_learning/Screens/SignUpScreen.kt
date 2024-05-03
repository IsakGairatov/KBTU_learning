package Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.EditField
import com.example.assignment1.R
import com.example.assignment1.User
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.users


@Composable
fun RegistrationPage(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToSignIn : () -> Unit
){

    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
//    val passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(95, 141, 77, 255))
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(R.string.sign_up),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
//            color = Color(254,208,73)
        color = Color.White
        )
        Spacer(Modifier.height(16.dp))
        EditField(
            label = com.example.assignment1.R.string.user_name,
            keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = userName,
            onValueChanged = { userName = it},
//            color = Color(254,208,73)
            color = Color.White,
            passwordVisibility = true
        )
        EditField(
            label = com.example.assignment1.R.string.email,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = email,
            onValueChanged = { email = it},
//            color = Color(254,208,73)
            color = Color.White,
            passwordVisibility = true
        )
        EditField(
            label = com.example.assignment1.R.string.phone_number,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = mobile,
            onValueChanged = { mobile = it},
//            color = Color(254,208,73)
            color = Color.White,
            passwordVisibility = true
        )
        EditField(
            label = com.example.assignment1.R.string.password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            value = password,
            onValueChanged = { password = it},
//            color = Color(254,208,73)
            color = Color.White,
            passwordVisibility = false
        )
        Button(
            onClick = {
//                var user = User(name=userName, password = password, email = email, mobile = mobile)
                users.add(User(name=userName, password = password, email = email, mobile = mobile))
                navigateToHome()
            },
            modifier= Modifier
                .align(Alignment.End)
                .border(
                    width = 3.dp,
                    shape = RoundedCornerShape(18.dp),
                    color = Color.Unspecified
                )
                .padding(end = 15.dp)
            ,
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color(254,208,73))
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        )
        {
              Text(text = "Complete registration",
                  color = Color.DarkGray,
              )
        }
        Row {
            Text(
                text = "Already registered?  ",
//                color = Color(254,208,73)
                color = Color.White
            )
            Text(
                text = "Sign in",
                modifier = Modifier
                    .clickable(
                        onClick = navigateToSignIn
                    ),
                color = Color(77,181,249)
            )
        }
    }
}

private infix fun <E> MutableList<E>.by(remember: MutableState<String>) {

}


//@Composable
//fun warning(){
//    Text(
//        text = "You're not authorized",
//        color = Color.Red
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun RegistrationPagePreview() {
//    Assignment1Theme {
//        RegistrationPage()
//    }
//}