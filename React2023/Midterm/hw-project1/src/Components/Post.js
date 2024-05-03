import {Space, Card} from "antd";
import {UserInfo} from "../Data/Data";

const Post = (prop) => {
    const {id, text, userId} = prop
    const User = UserInfo.find((item) => item.UserId == userId).UserName

    return (
            <Card><Space direction={"vertical"}>
                <h1>{User}</h1>
                {text}
            </Space></Card>

    )
}


export default Post