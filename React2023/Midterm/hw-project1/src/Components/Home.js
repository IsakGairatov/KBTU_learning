import Post from "./Post";
import {Posts} from "../Data/Data";
import {Button, Input, Space} from "antd";
import {UserInfo} from "../Data/Data";
import {useState} from "react";


const HomePage = () => {
    const User = UserInfo.find((item) => item.UserId == 1).UserName
    const MyPosts = Posts.filter((it) => it.userId === 1)

    const [NewPosts, SetPosts] = useState([{id: 0, userId: 1, text: "New"}])
    const [text, setText] = useState("")

    const setnewText = (e) =>
    {
        setText(e.target.value)
    }
    const addNewPost = () =>
    {
        NewPosts.push({
            id: 0,
            userId: 1,
            text: text
        })
    }

    return (
        <>
            <h1>This is the page of {User}</h1>

            <div>
                <input placeholder={"Добавить пост"} onChange={setnewText}></input>
                <Button onClick={addNewPost}>Нажать</Button>
            </div>

            <Space direction={"vertical"}>
                {MyPosts.map((el) => <Post {...(el)}/>)}
                {NewPosts.map((el) => <Post {...(el)}/>)}
            </Space>
        </>
    )
}


export default HomePage