import {Posts, UserInfo} from "../Data/Data";
import {useState} from "react";
import {Button, Space} from "antd";
import Post from "./Post";

const HomePage = () => {


    const User = UserInfo.find((item) => item.UserId == 1).UserName
    const MyPosts = Posts.filter((it) => it.userId === 1)

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