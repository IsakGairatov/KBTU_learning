import {Space} from "antd";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import {auth} from "../Firebs/FireBaser";
import {signOut} from "firebase/auth"

const Hat = (x) => {
    const [isLog, setLog] = useState(parseInt(localStorage.getItem("isLog"), 10))
    const navigate = useNavigate();
    function logout() {
        signOut(auth).then(() => {
            navigate(('/'))
        }).catch((error) => {
        });
    }


    return ( <Space direction="horizontal">

            <Link to={'/'}>Домой</Link>
        {!auth.currentUser ? (<Link to={'/signupin/1'}>Войти</Link>) : (<><Link to={'/mypage/'}>Моя страница</Link> <p onClick={logout}>Выйти</p> </>)}

        </Space>
    )
}

export default Hat;