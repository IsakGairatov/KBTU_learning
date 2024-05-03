import {Card, Input, Space} from "antd";
import TextArea from "antd/es/input/TextArea";
import {addDoc, collection} from "firebase/firestore";
import {auth, db} from "../Firebs/FireBaser";

const CommentWriter = (probs) => {
    const commentRef = collection(db, "comments")
    const {id} = probs
    const write = async () => {
        try {
            await addDoc(commentRef, {
                User: auth.currentUser.email,
                Text: document.getElementById("cT").value,
                MangaId: id,
                Time: Date(Date.now())
            });
            document.getElementById("cT").value = "";
        } catch (err) {
            console.log(err)
        }
    }

    return (<div>
        <Card>
            <Space direction={"horizontal"}>
                <input
                    id = "cT"
                    type={"text"}
                    style={{width: "700px", height: "150px"}}
                />

                <button onClick={write} style={{width: "100px", height: "50px"}}>Отправить</button>
            </Space>

        </Card>
    </div>)
}

export default CommentWriter;