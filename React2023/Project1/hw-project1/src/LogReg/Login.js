import {Card, Input, Space} from "antd";
import {Button} from "antd/lib";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import {auth} from "../Firebs/FireBaser";
import {createUserWithEmailAndPassword, signInWithEmailAndPassword} from "firebase/auth"


const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState("")

    const navigate = useNavigate();
    const goToMainPage = () => navigate('/');

    const login = async() => {
        await signInWithEmailAndPassword(auth, email, password).then(() => {
            navigate('/')
        }).catch((error) => {});
    }

    return ( <>
            <Card size={"small"}>
                <Space direction={"vertical"}>
                    <h>Войти в аккаунт</h>
                    <Input placeholder={"Введите Имя"}
                           onChange = {(e) => setEmail(e.target.value)}
                           style={{width: "370px"}}/>
                    <Input placeholder={"Пороль"}
                           onChange = {(e) => setPassword(e.target.value)}
                           type = "password"
                           style={{width: "370px"}}/>
                    <Button onClick={login}>Войти</Button> <Link to={'/signupin/2'}>зарегистрироваться</Link>
                </Space>
            </Card>


        </>
    )
}

export default Login;