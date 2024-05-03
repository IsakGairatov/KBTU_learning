import {Space} from "antd";
import Hat from "../MainPage/Hat";
import {updateDoc, doc} from "firebase/firestore";
import {auth, db} from "../Firebs/FireBaser";
import {useNavigate} from "react-router-dom";
import AdPage from "./AdPage";

const Admaker = () => {
    const nav = useNavigate()
    const done = async () => {
        try {

            const data = {
                "img": document.getElementById("img").value,
                "url": document.getElementById("url").value,
                "title": document.getElementById("title").value,
                "desc": document.getElementById("desc").value
            }
            const adRef = doc(db, "ad", "1");

            await updateDoc(adRef, data);

            nav('/')

        } catch (err) {
            console.log(err)
        }


    }

    return(
        <div>
            <AdPage/>
            <Hat/>
        <div style={{textAlign: "center", marginTop: 50, marginBottom: 200}}>
            <Space direction={"vertical"}>

                <h1>Настройка рекламы</h1>
                    <input id={"img"} placeholder={"ссылку на изображение"}/>
                    <input id={"title"} placeholder={"Заголовок"}/>
                    <input id={"url"} placeholder={"ссылка"}/>
                    <input
                        id = "desc"
                        type={"text"}
                        style={{width: "700px", height: "150px"}}
                        placeholder={"Текс рекламы"}
                    />
                <button onClick={done}>Готово</button>

            </Space>
    </div>
            </div>)
}

export default Admaker