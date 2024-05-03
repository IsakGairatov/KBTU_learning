import {Card, Input, Space} from "antd";
import {Button} from "antd/lib";
import {Users} from "../Data/MockApi";
import {useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import {createUserWithEmailAndPassword} from "firebase/auth"
import {auth} from "../Firebs/FireBaser";

const Regin = () => {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState("")

    const navigate = useNavigate();
    const GoToLogPage = () => navigate('/signupin/1')

    const signup = async () => {
        await createUserWithEmailAndPassword(auth, email, password).then(() => {
            navigate(('/'))
        }).catch((error) => {});
    }



    return ( <>
            <Card size={"small"}>
                <Space direction={"vertical"}>
                    <h>Регистрация</h>
                    <Input placeholder={"Введите Имя"}
                           onChange = {(e) => setEmail(e.target.value)}
                           style={{width: "370px"}}/>
                    <Input placeholder={"Пороль"}
                           onChange = {(e) => setPassword(e.target.value)}
                           type = "password"
                           style={{width: "370px"}}/>
                    <Button onClick={signup}>Сохранить</Button> <Link to={'/signupin/1'}>Войти</Link>

                </Space>
            </Card>
        </>
    )
}

export default Regin;